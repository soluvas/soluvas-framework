package org.soluvas.data.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AggregatingSupplier;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.SupplierXmiClasspathScanner;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.MixinCatalog;
import org.soluvas.data.MixinManager;
import org.soluvas.data.TermManager;
import org.soluvas.data.impl.MixinManagerImpl;
import org.soluvas.data.impl.TermManagerImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Multitenant-aware {@link Configuration} for {@link DataCatalog}, {@link MixinCatalog}, and {@link TermManager} beans.
 * @author rudi
 */
@Configuration @Lazy
@ComponentScan("org.soluvas.data.shell")
public class TenantDataConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(TenantDataConfig.class);
//	@Inject @DataFolder
//	private String dataFolder;
	@Inject
	private BeanFactory beanFactory;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private TenantRef tenant;
	
	@Bean
	public ImmutableMap<String, DataCatalog> dataCatalogMap() throws IOException {
		final Map<String, File> dataDirMap = tenantConfig.dataDirMap();
		final ImmutableMap.Builder<String, DataCatalog> dataCatalogMapb = ImmutableMap.builder();
		for (final Map.Entry<String, AppManifest> tenant : tenantConfig.tenantMap().entrySet()) {
			final String tenantId = tenant.getKey();
			@Nullable
			final File dataDir = dataDirMap.get(tenantId);
			final AggregatingSupplier<DataCatalog> aggregator = new AggregatingSupplier<>(DataFactory.eINSTANCE,
					DataPackage.Literals.DATA_CATALOG, ImmutableList.<Supplier<DataCatalog>>of());
			final SupplierXmiClasspathScanner<DataCatalog> scanner;
			if (dataDir != null) {
				scanner = new SupplierXmiClasspathScanner<>(DataPackage.eINSTANCE, DataCatalog.class,
						aggregator, TenantDataConfig.class.getClassLoader(), dataDir);
			} else {
				scanner = new SupplierXmiClasspathScanner<>(DataPackage.eINSTANCE, DataCatalog.class,
						aggregator, TenantDataConfig.class.getClassLoader());
			}
			final DataCatalog dataCatalog = aggregator.get();
			dataCatalogMapb.put(tenant.getKey(), dataCatalog);
		}
		return dataCatalogMapb.build();
	}
	
	@Bean
	public ImmutableMap<String, MixinCatalog> mixinCatalogMap() throws IOException {
		final Map<String, File> dataDirMap = tenantConfig.dataDirMap();
		final ImmutableMap.Builder<String, MixinCatalog> mixinCatalogMapb = ImmutableMap.builder();
		for (final Map.Entry<String, AppManifest> tenant : tenantConfig.tenantMap().entrySet()) {
			final String tenantId = tenant.getKey();
			@Nullable
			final File dataDir = dataDirMap.get(tenantId);
			
			final File tenantMixinCatalogFile = new File(dataDir, "common/base.MixinCatalog.xmi");
			final Supplier<MixinCatalog> supplier;
			if (tenantMixinCatalogFile.exists()) {
				// If tenant-specific MixinCatalog exists, use it
				log.info("Using tenant-specific MixinCatalog from {}", tenantMixinCatalogFile);
				supplier = new OnDemandXmiLoader<>(DataPackage.eINSTANCE, tenantMixinCatalogFile.getAbsoluteFile());
			} else {
				// otherwise, use default MixinCatalog
				// TODO: don't hardcode default mixin classpath name
				log.info("Using default MixinCatalog from {}", tenantMixinCatalogFile);
				supplier = new OnDemandXmiLoader<>(DataPackage.eINSTANCE, TenantDataConfig.class, 
						"/id/co/bippo/common/base.MixinCatalog.xmi");
			}
			final MixinCatalog mixinCatalog = supplier.get();
			mixinCatalogMapb.put(tenant.getKey(), mixinCatalog);
		}
		return mixinCatalogMapb.build();
	}
	
	@Bean
	public ImmutableMap<String, MixinManager> mixinMgrMap() throws IOException {
		final Map<String, File> dataDirMap = tenantConfig.dataDirMap();
		final ImmutableMap.Builder<String, MixinManager> mixinMgrMapb = ImmutableMap.builder();
		for (final Map.Entry<String, AppManifest> tenant : tenantConfig.tenantMap().entrySet()) {
			final String tenantId = tenant.getKey();
			final MixinManagerImpl mixinMgr = new MixinManagerImpl(mixinCatalogMap().get(tenantId));
			mixinMgrMapb.put(tenant.getKey(), mixinMgr);
		}
		return mixinMgrMapb.build();
	}
	
	@Bean
	public ImmutableMap<String, TermManager> termMgrMap() throws IOException {
		final Map<String, File> dataDirMap = tenantConfig.dataDirMap();
		final ImmutableMap.Builder<String, TermManager> termMgrMapb = ImmutableMap.builder();
		for (final Map.Entry<String, AppManifest> tenant : tenantConfig.tenantMap().entrySet()) {
			final String tenantId = tenant.getKey();
			final TermManagerImpl termMgr = new TermManagerImpl(dataCatalogMap().get(tenantId));
			termMgrMapb.put(tenant.getKey(), termMgr);
		}
		return termMgrMapb.build();
	}
	
//	@Bean @Lazy(false)
//	public SupplierXmiClasspathScanner<DataCatalog> builtinDataCatalogsScanner() {
//		return new SupplierXmiClasspathScanner<DataCatalog>(DataPackage.eINSTANCE, DataCatalog.class,
//				dataCatalogSupplier(), DataConfig.class);
//	}
	
	@Bean @Scope("request")
	public DataCatalog dataCatalog() throws IOException {
		final String tenantId = tenant.getTenantId();
		return Preconditions.checkNotNull(dataCatalogMap().get(tenantId),
				"No DataCatalog for tenant '%s'. %s available DataCatalogs: %s",
				tenantId, dataCatalogMap().size(), dataCatalogMap().keySet());
	}

	@Bean @Scope("request")
	public MixinCatalog mixinCatalog() throws IOException {
		final String tenantId = tenant.getTenantId();
		return Preconditions.checkNotNull(mixinCatalogMap().get(tenantId),
				"No MixinCatalog for tenant '%s'. %s available MixinCatalogs: %s",
				tenantId, mixinCatalogMap().size(), mixinCatalogMap().keySet());
	}

	@Bean @Scope("request")
	public MixinManager mixinMgr() throws IOException {
		final String tenantId = tenant.getTenantId();
		return Preconditions.checkNotNull(mixinMgrMap().get(tenantId),
				"No MixinManager for tenant '%s'. %s available MixinManagers: %s",
				tenantId, mixinMgrMap().size(), mixinMgrMap().keySet());
	}
	
	@Bean @Scope("request")
	public TermManager termMgr() throws IOException {
		final String tenantId = tenant.getTenantId();
		return Preconditions.checkNotNull(termMgrMap().get(tenantId),
				"No TermManager for tenant '%s'. %s available TermManagers: %s",
				tenantId, termMgrMap().size(), termMgrMap().keySet());
	}
	
}
