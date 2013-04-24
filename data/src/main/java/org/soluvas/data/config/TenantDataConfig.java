package org.soluvas.data.config;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.soluvas.commons.AggregatingSupplier;
import org.soluvas.commons.DelegatingSupplier;
import org.soluvas.commons.SupplierXmiClasspathScanner;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.MixinManager;
import org.soluvas.data.TermManager;
import org.soluvas.data.impl.MixinManagerImpl;
import org.soluvas.data.impl.TermManagerImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Supplier;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
@Configuration @Lazy
public class TenantDataConfig {
	
//	@Inject @DataFolder
//	private String dataFolder;
	@Inject
	private BeanFactory beanFactory;
	
	private static final Cache<String, DelegatingSupplier<DataCatalog>> dataCatalogCache = 
			CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
	
	private String getDataFolder() {
		return beanFactory.getBean("dataFolder", String.class);
	}
	
	@Bean @Scope("request")
	public DelegatingSupplier<DataCatalog> dataCatalogSupplier() throws ExecutionException {
		return dataCatalogCache.get(getDataFolder(), new Callable<DelegatingSupplier<DataCatalog>>() {
			@Override
			public DelegatingSupplier<DataCatalog> call() throws Exception {
				final AggregatingSupplier<DataCatalog> aggregator = new AggregatingSupplier<>(DataFactory.eINSTANCE,
						DataPackage.Literals.DATA_CATALOG, ImmutableList.<Supplier<DataCatalog>>of());
				final SupplierXmiClasspathScanner<DataCatalog> scanner = new SupplierXmiClasspathScanner<DataCatalog>(DataPackage.eINSTANCE, DataCatalog.class,
						aggregator, TenantDataConfig.class.getClassLoader(), getDataFolder());
				return aggregator;
			}
		});
	}
	
//	@Bean @Lazy(false)
//	public SupplierXmiClasspathScanner<DataCatalog> builtinDataCatalogsScanner() {
//		return new SupplierXmiClasspathScanner<DataCatalog>(DataPackage.eINSTANCE, DataCatalog.class,
//				dataCatalogSupplier(), DataConfig.class);
//	}
	
	@Bean @Scope("request")
	public DataCatalog dataCatalog() throws ExecutionException {
		return dataCatalogSupplier().get();
	}

	@Bean @Scope("request")
	public MixinManager mixinMgr() throws ExecutionException {
		return new MixinManagerImpl(dataCatalog());
	}
	
	@Bean @Scope("request")
	public TermManager termMgr() throws ExecutionException {
		return new TermManagerImpl(dataCatalog());
	}
	
}
