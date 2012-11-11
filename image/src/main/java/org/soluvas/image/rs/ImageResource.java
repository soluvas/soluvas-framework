package org.soluvas.image.rs;

import java.net.URL;
import java.util.List;

import javax.annotation.Nullable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.jaxrs.JaxrsUtils;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * Provides ImageConfig.
 * @author ceefour
 */
@Path("org.soluvas.image")
public class ImageResource {
	
	private transient Logger log = LoggerFactory.getLogger(ImageResource.class);
	@Deprecated
	private transient BundleContext bundleContext;
	private transient @Context UriInfo uriInfo;
	
	public ImageResource(BundleContext bundleContext) {
		super();
		this.bundleContext = bundleContext;
	}

	@GET @Path("imageConfigs.js")
	@Produces("text/javascript")
	public String getImageConfigs() throws InvalidSyntaxException {
		final TenantRef tenant = JaxrsUtils.getTenant(uriInfo);
		final String filter = String.format("(&(tenantId=%s)(tenantEnv=%s))", tenant.getTenantId(), tenant.getTenantEnv());
		log.trace("Getting imageConfigs.js for {} using {}", tenant, filter);
		List<ServiceReference<ImageRepository>> refs = ImmutableList.copyOf(bundleContext.getServiceReferences(ImageRepository.class,
				filter));
		try {
			final List<ImageRepository> imageRepos = Lists.transform(refs, new Function<ServiceReference<ImageRepository>, ImageRepository>() {
				@Override @Nullable
				public ImageRepository apply(@Nullable ServiceReference<ImageRepository> input) {
					return bundleContext.getService(input);
				}
			});
			log.trace("Got {} image repositories for {}: {}", imageRepos.size(), tenant, imageRepos);
			URL stgUrl = ImageResource.class.getResource("imageConfigs.stg");
			STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
			ST configsSt = stg.getInstanceOf("imageConfigs");
			configsSt.add("imageRepos", imageRepos);
			// render
			String renderedJs = configsSt.render(80);
			return renderedJs;
		} finally {
			for (ServiceReference<ImageRepository> ref : refs) {
				bundleContext.ungetService(ref);
			}
		}
	}

}
