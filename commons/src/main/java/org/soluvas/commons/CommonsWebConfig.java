package org.soluvas.commons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.util.AppUtils;
import org.soluvas.json.EmfModule;
import org.soluvas.json.JacksonMapperFactory;
import org.soluvas.json.JacksonMapperFactoryImpl;
import org.soluvas.json.LowerEnumModule;
import org.soluvas.json.jscience.JscienceModule;
import org.soluvas.json.money.JodaMoneyModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * Replacement of OSGI-INF/blueprint/commons.xml
 * for Spring applications.
 * Requires {@link ServletContext} aka WebApplicationContext
 * to determine the {@link TenantRef} hence, <code>dataDir</code>.
 * @author rudi
 */
@Configuration @Lazy
public class CommonsWebConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(CommonsWebConfig.class);
	@Autowired
	private ServletContext servletContext;
//	@Value("#{systemProperties['user.home']}/${tenantId}_${tenantEnv}")
//	public File dataDir;
	
	@Bean
	public TenantRef tenantRef() {
		final String contextPath = servletContext.getContextPath();
		final Matcher tenantMatcher = Pattern.compile("\\/([^_]+)_([^_]+)_([^_]+)").matcher(contextPath);
		Preconditions.checkState(tenantMatcher.matches(),
				"ContextPath %s must match pattern: /{tenantId}_{tenantEnv}_{appCode}",
				contextPath);
		final TenantRef tenant = new TenantRef(tenantMatcher.group(1), tenantMatcher.group(1), tenantMatcher.group(2));
		log.info("Soluvas Commons Deployment Configuration for {}: clientId={} tenantId={} tenantEnv={} appCode={}",
				contextPath, tenant.getClientId(), tenant.getTenantId(), tenant.getTenantEnv(), tenantMatcher.group(3));
		return tenant;
	}
	
	@Bean @DataFolder
	public String dataFolder() {
		return System.getProperty("user.home") + "/" + tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv();
	}

	@Bean(destroyMethod="shutdown")
	public ExecutorService networkExecutor() {
		return AppUtils.newNetworkExecutor();
	}
	
	@Bean(destroyMethod="shutdown")
	public ExecutorService cpuExecutor() {
		return AppUtils.newCpuExecutor();
	}

	// TODO: EventBus subscribers
	@Bean
	public EventBus globalEventBus() {
		return new AsyncEventBus("global", networkExecutor());
	}
	
	@Bean
	public WebAddress webAddress() {
		return new XmiObjectLoader<WebAddress>(CommonsPackage.eINSTANCE,
				new File(dataFolder(), "model/custom.WebAddress.xmi").toString()).get();
	}

	@Bean
	public AppManifest appManifest() {
		return new XmiObjectLoader<AppManifest>(CommonsPackage.eINSTANCE,
				new File(dataFolder(), "common/" + tenantRef().getTenantId() + "_" + tenantRef().getTenantEnv() + ".AppManifest.xmi").toString()).get();
	}
	
	@Bean
	public JacksonMapperFactory jacksonMapperFactory() {
		final List<Supplier<Module>> modules = new ArrayList<>();
		modules.add(Suppliers.<Module>ofInstance(new JodaModule()));
		modules.add(Suppliers.<Module>ofInstance(new GuavaModule()));
		modules.add(Suppliers.<Module>ofInstance(new JodaMoneyModule()));
		modules.add(Suppliers.<Module>ofInstance(new LowerEnumModule()));
		modules.add(Suppliers.<Module>ofInstance(new EmfModule()));
		modules.add(Suppliers.<Module>ofInstance(new JscienceModule()));
		return new JacksonMapperFactoryImpl(modules);
	}
	
	@Bean
	public ObjectMapper jacksonMapper() {
		return jacksonMapperFactory().get();
	}
	
	// TODO: shell commands
}
