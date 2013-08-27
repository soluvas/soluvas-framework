package org.soluvas.commons.config;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Cpu;
import org.soluvas.commons.Network;
import org.soluvas.commons.tenant.TenantRefImpl;
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
import org.springframework.core.env.Environment;

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
 * to determine the {@link TenantRefImpl} hence, <code>dataDir</code>.
 * 
 * <p>Configurable properties:
 * 
 * <ol>
 * 	<li>{@code int httpMaxConnections}. Maximum number of HTTP Connections pooled by {@link #httpClientConnMgr()}, default: 20.</li>
 * 	<li>{@code boolean httpTrustAll}. Trust all/unsigned SSL certificates. Default: false.</li>
 * </ol>
 * 
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
	
	@Inject
	private Environment env;
	
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
	public ClientConnectionManager httpClientConnMgr() throws KeyManagementException, NoSuchAlgorithmException {
		final int maxConnections = env.getProperty("httpMaxConnections", Integer.class, 20);
		final boolean trustAll = env.getProperty("httpTrustAll", Boolean.class, false);
		log.info("Creating Pooling HTTP ClientConnectionManager with {} max connections, trust all SSL certs: {}",
				maxConnections, trustAll);

		final SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		final SSLSocketFactory sslSocketFactory;
		if (trustAll) {
			final SSLContext context = SSLContext.getInstance("TLS");
			context.init(
					null,
					new TrustManager[] { new X509TrustManager() {
						@Override
						public java.security.cert.X509Certificate[] getAcceptedIssuers() {
							return null;
						}

						@Override
						public void checkClientTrusted(
								java.security.cert.X509Certificate[] certs,
								String authType) {
						}

						@Override
						public void checkServerTrusted(
								java.security.cert.X509Certificate[] certs,
								String authType) {
						}
					} }, null);
			sslSocketFactory = new SSLSocketFactory(context, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		} else {
			sslSocketFactory = SSLSocketFactory.getSocketFactory();
		}
		schemeRegistry.register(new Scheme("https", 443, sslSocketFactory));
		
		final PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
		cm.setMaxTotal(maxConnections);
		cm.setDefaultMaxPerRoute(maxConnections);
		return cm;
	}
	
	@Bean
	public HttpClient httpClient() throws KeyManagementException, NoSuchAlgorithmException {
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
