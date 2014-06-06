package org.soluvas.commons.tenant;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.PushResult;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.Expandable;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.VersioningMode;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.util.GitUtils;

import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * TenantXmiBeansImpl (satu object per tenant) yang support:
 * 
 * <ol>
 * <li>{@link TenantBeans} behavior
 * <li>konfigurasi local/commit/sync
 * <li>{@link Expandable#expand(Map)}
 * <li>in the future: {{xyzCatalog}} jangan dipakai saat runtime, khusus file XMI aja. BTW ini beda kasus, karena {{Category}} ada banyak per tenant
 * <li>in the future: Override, contoh: CategoryOverride, untuk meng-override di {{base}}, misal set status jadi {{VOID}} atau ganti {{name}}
 * <li>prepare for RDF/Stanbol/Jena support
 * <li>hotel-templatable, seperti yang dipakai oleh {@link AppManifest} dan {{BippoSysConfig}}
 * </ol>
 * 
 * <p>Used by: (see {{BippoTenantProvisioner}})
 * 
 * <ol>
 * <li>{{FeatureSet}}
 * <li>{{FeaturedShop}}
 * <li>{{Mall}}
 * <li>{@link AppManifest} -- maybe
 * <li>{{BippoSysConfig}}
 * <li>{{FreeShippingRule}}
 * </ol>
 * 
 * @see <a href="https://idbippo.atlassian.net/browse/BC-1858">BC-1858: TenantXmiBeansImpl yang support konfigurasi local/commit/sync, dan expand()</a>
 * @see TenantBeans
 * @see org.soluvas.data.repository.XmiRepositoryBase
 * @author ceefour
 */
public class TenantXmiBeansImpl<T extends EObject> implements TenantRepositoryListener, TenantXmiBeans<T> {
	
	protected final Logger log;
	
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private TenantSelector tenantSelector;
	@Inject
	private TenantRepository<?> tenantRepo;
	
	private final EClass eClass;
	/**
	 * Contains the <b>expanded</b> entities. These are not meant to be modified.
	 * Modifying an entity will always read the <b>original unexpanded</b> XMI from disk and write the modifications back to disk.
	 */
	private final ConcurrentHashMap<String, T> entityMap = new ConcurrentHashMap<>();
	private final VersioningMode versioningMode;
	private final UriTemplate pathTemplate;

	/**
	 * @param pathTemplate Path URI template. It must use {@code file:} scheme, absolute URI.
	 * 		Available variables are: {@code tenantId}, {@code tenantEnv}, {@code dataDir}.
	 * @param xmiVersioningMode
	 */
	public TenantXmiBeansImpl(EClass eClass, String pathTemplate, VersioningMode xmiVersioningMode) {
		super();
		log = LoggerFactory.getLogger(getClass().getName() + "/" + eClass.getName());
		this.eClass = eClass;
		this.versioningMode = xmiVersioningMode;
		try {
			this.pathTemplate = UriTemplate.fromTemplate(pathTemplate);
		} catch (MalformedUriTemplateException e) {
			throw new TenantException(e, "Cannot create %s TenantXmiBeansImpl: %s", getClass().getName(), e);
		}
	}
	
	@PostConstruct
	public void init() {
		final ImmutableSet<String> initialTenantIds = tenantConfig.tenantMap().keySet();
		log.info("Loading {} initial {}s: {}", initialTenantIds.size(), eClass.getName(), initialTenantIds);
		for (final String tenantId : initialTenantIds) {
			reload(tenantId);
		}
		log.info("Loaded {} initial {}s: {}", initialTenantIds.size(), eClass.getName(), initialTenantIds);
		
		tenantRepo.addListener(this);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.impl.TenantXmiBeans#getVersioningMode()
	 */
	@Override
	public VersioningMode getVersioningMode() {
		return versioningMode;
	}
	
	protected File getFileFor(String tenantId) {
		final ImmutableMap<String, Object> scope = ImmutableMap.<String, Object>of(
				"tenantId", tenantId, "tenantEnv", tenantConfig.getTenantEnv(), 
				"dataDir", tenantConfig.dataDirMap().get(tenantId).toString());
		final String path;
		try {
			path = pathTemplate.expand(scope);
		} catch (Exception e) {
			throw new TenantException(e, "Cannot get %s file path for tenant '%s' template: %s scope: %s",
					getClass().getName(), tenantId, pathTemplate.getTemplate(), scope);
		}
		try {
			return new File(URI.create(path));
		} catch (Exception e) {
			throw new TenantException(e, "Invalid %s file URI '%s' for tenant '%s' template: %s scope: %s",
					getClass().getName(), path, tenantId, pathTemplate.getTemplate(), scope);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.impl.TenantXmiBeans#count()
	 */
	@Override
	public long count() {
		return entityMap.size();
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.impl.TenantXmiBeans#getOriginal(java.lang.String)
	 */
	@Override
	public T getOriginal(String tenantId) throws IllegalArgumentException {
		Preconditions.checkArgument(entityMap.containsKey(tenantId),
				"Entity '%s' not found. %s available: %s", tenantId, entityMap.size(), entityMap.keySet());
		final File file = getFileFor(tenantId);
		log.debug("Loading original {} for '{}' from {}", eClass.getName(), tenantId, file);
		final T entity = new OnDemandXmiLoader<T>(eClass.getEPackage(), file).autoExpand(false).get();
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.impl.TenantXmiBeans#getExpanded(java.lang.String)
	 */
	@Override
	public T getExpanded(String tenantId) throws IllegalArgumentException {
		Preconditions.checkArgument(entityMap.containsKey(tenantId),
				"Entity '%s' not found. %s available: %s", tenantId, entityMap.size(), entityMap.keySet());
		return entityMap.get(tenantId);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.impl.TenantXmiBeans#getCurrentExpanded()
	 */
	@Override
	public T getCurrentExpanded() throws IllegalArgumentException {
		return getExpanded(tenantSelector.tenantRef().getTenantId());
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.impl.TenantXmiBeans#modify(java.lang.String, T)
	 */
	@Override
	public T modify(String tenantId, T entity) {
		final File file = getFileFor(tenantId);
		Preconditions.checkState(file.exists(),
				"Cannot modify %s XMI for '%s', file '%s' must already exist", eClass.getName(), tenantId, file);
		log.debug("Modifying {} XMI for '{}' as {}", eClass.getName(), tenantId, file);
		final ResourceSet rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		final Resource res = rset.createResource(org.eclipse.emf.common.util.URI.createFileURI(file.getPath()));
		res.getContents().add(EcoreUtil.copy(entity));
		try {
			res.save(ImmutableMap.<String, Object>of(
					XMIResource.OPTION_LINE_WIDTH, 80,
					XMIResource.OPTION_DECLARE_XML, true,
					XMIResource.OPTION_ENCODING, "UTF-8",
					XMIResource.OPTION_SCHEMA_LOCATION, true));
			res.unload();
			log.info("Modifying {} XMI for '{}' as {}", eClass.getName(), tenantId, file);
		} catch (IOException e) {
			throw new TenantException(e, "Cannot modify %s XMI for '%s' as %s", eClass.getName(), tenantId, file);
		}
		
		commitAndSync(tenantId, file);
		reload(tenantId);
		return entity;
	}
	
	/**
	 * @param tenantId
	 * @return Expanded entity.
	 */
	private T reload(String tenantId) {
		final File file = getFileFor(tenantId);
		log.debug("Loading and expanding {} XMI for '{}' from {}", eClass.getName(), tenantId, file);
		final ImmutableMap<String, String> scope = ImmutableMap.<String, String>of();
		final T entity = new OnDemandXmiLoader<T>(eClass.getEPackage(), file, scope).get();
		entityMap.put(tenantId, entity);
		return entity;
	}

	/**
	 * If necessary, does a commit and sync according to {@link #versioningMode}.
	 * @param tenantId
	 */
	private void commitAndSync(String tenantId, File upFile) {
		if (versioningMode == VersioningMode.WORKING || versioningMode == VersioningMode.SYNC) {
			// Commit
			GitUtils.disableStrictHostKeyChecking();
			
			final Repository gitRepo;
			final Git git;
			try {
				final File parentDir = upFile.getParentFile().getCanonicalFile();
				gitRepo = new RepositoryBuilder().findGitDir(parentDir).setMustExist(true).build();
				git = new Git(gitRepo);
			} catch (IOException e) {
				throw new TenantException(e, "Cannot get Git Repository for '%s'", upFile);
			}

			final String message;
			try {
				log.debug("Adding {} in {}", upFile, gitRepo);
				git.add().addFilepattern(".").call();
				log.debug("Committing {} in {}", upFile, gitRepo);
				message = String.format("Changed %s XMI for '%s': %s at %s", 
						eClass.getName(), tenantId, upFile.getName(), new DateTime());
				final RevCommit revCommit = git.commit().setAll(true).setMessage(message).call();
				log.info("Committed '{}' as {} in {}", message, revCommit, gitRepo);
			} catch (Exception e) {
				throw new TenantException(e, "Cannot commit '%s' to Git repository: %s", upFile, e);
			}

			// Sync
			if (versioningMode == VersioningMode.SYNC) {
				try {
					//Pull
					log.debug("Pulling {} due to '{}'", gitRepo, message);
					final PullResult pullResult = git.pull().call();
					// FetchResult doesn't have proper toString()
					final String fetchResult = pullResult.getFetchResult() != null ? pullResult.getFetchResult().getTrackingRefUpdates() + " from " + pullResult.getFetchResult().getURI() : null;
					log.info("Pulled {} from {}. Fetch: {}. Merge: {}.", gitRepo, pullResult.getFetchedFrom(), fetchResult,
							pullResult.getMergeResult());
					// push: MUST set default remote AND branch
					log.debug("Pushing {} due to '{}'", gitRepo, message);
					final Iterable<PushResult> pushResults = git.push().call();
					log.info("Pushed {}: {}", gitRepo, pushResults);
				} catch (Exception e) {
					throw new TenantException(e, "Cannot pull/push '%s' to Git repository: %s", upFile, e);
				}
			}
		}
	}

	@Override
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
		final ImmutableSet<String> tenantIds = starting.getAddeds().keySet();
		log.info("Loading and expanding {} {} XMIs: {}", 
				tenantIds.size(), eClass.getName(), tenantIds);
		for (String tenantId : tenantIds) {
			reload(tenantId);
		}
		log.info("Loaded and expanded {} {} XMIs: {}", 
				tenantIds.size(), eClass.getName(), tenantIds);
	}

	@Override
	public void onTenantsStopping(TenantsStopping stopping) throws Exception {
		final ImmutableList<String> tenantIdsToRemove = ImmutableList.copyOf(stopping.getTenants().keySet());
		log.debug("Removing {} {} XMIs: {}",
				tenantIdsToRemove.size(), eClass.getName(), tenantIdsToRemove);
		for (String tenantId : tenantIdsToRemove) {
			entityMap.remove(tenantId);
		}
		log.info("Removed {} {} XMIs: {}", 
				tenantIdsToRemove.size(), eClass.getName(), tenantIdsToRemove);
	}

	/**
	 * Adds the entity, saves it to disk, then performs commit/sync based on {@link #getVersioningMode()}.
	 * @param id
	 * @param entity
	 * @return Unexpanded entity.
	 */
//	public T add(String id, T entity) {
//		return entity;
//	}
	
//	@Nullable
//	protected final String getId(T entity) {
//		for (Map.Entry<String, T> entry : entityMap.entrySet()) {
//			if (entry.getValue() == entity) {
//				return entry.getKey();
//			}
//		}
//		throw new IllegalArgumentException(String.format("Entity '%s' not found. %s available: %s",
//				entity, entityMap.size(), entityMap.keySet()));
//	}

}
