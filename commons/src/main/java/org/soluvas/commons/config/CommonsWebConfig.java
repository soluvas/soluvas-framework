package org.soluvas.commons.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.servlet.ServletContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Cpu;
import org.soluvas.commons.Network;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.util.AppUtils;
import org.soluvas.json.EmfModule;
import org.soluvas.json.JacksonMapperFactory;
import org.soluvas.json.JacksonMapperFactoryImpl;
import org.soluvas.json.LowerEnumModule;
import org.soluvas.json.jscience.JscienceModule;
import org.soluvas.json.money.JodaMoneyModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.logging.slf4j.SLF4JLogrImplFactory;
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
@ComponentScan("org.soluvas.push")
public class CommonsWebConfig {
	
	static {
		MorphiaLoggerFactory.registerLogger(SLF4JLogrImplFactory.class);
	}
	
	private static final Logger log = LoggerFactory
			.getLogger(CommonsWebConfig.class);
//	@Value("#{systemProperties['user.home']}/${tenantId}_${tenantEnv}")
//	public File dataDir;
	
//	@Bean
//	public Properties soluvasProperties() throws FileNotFoundException, IOException {
//		final Properties props = new Properties();
//		props.load(new FileReader(dataFolder() + "/etc/org.soluvas.cfg"));
//		return props;
//	}

	@Bean(destroyMethod="shutdown") @Network
	public ExecutorService networkExecutor() {
		return AppUtils.newNetworkExecutor();
	}
	
	@Bean(destroyMethod="shutdown") @Cpu
	public ExecutorService cpuExecutor() {
		return AppUtils.newCpuExecutor();
	}

	// TODO: EventBus subscribers
	@Bean
	public EventBus globalEventBus() {
		return new AsyncEventBus("global", networkExecutor());
	}
	
	@Bean(destroyMethod="shutdown")
	public ClientConnectionManager httpClientConnMgr() {
		return new PoolingClientConnectionManager();
	}
	
	@Bean
	public HttpClient httpClient() {
		return new DecompressingHttpClient(new DefaultHttpClient(httpClientConnMgr()));
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
