package org.soluvas.data.config;

import javax.inject.Inject;

import org.soluvas.commons.AggregatingSupplier;
import org.soluvas.commons.DataFolder;
import org.soluvas.commons.DelegatingSupplier;
import org.soluvas.commons.SupplierXmiClasspathScanner;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.MixinManager;
import org.soluvas.data.TermManager;
import org.soluvas.data.DataPackage.Literals;
import org.soluvas.data.impl.MixinManagerImpl;
import org.soluvas.data.impl.TermManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
@Configuration @Lazy
public class DataConfig {
	
	@Inject @DataFolder
	private String dataFolder;
	
	@Bean
	public DelegatingSupplier<DataCatalog> dataCatalogSupplier() {
		final AggregatingSupplier<DataCatalog> aggregator = new AggregatingSupplier<DataCatalog>(DataFactory.eINSTANCE,
				DataPackage.Literals.DATA_CATALOG, ImmutableList.<Supplier<DataCatalog>>of());
		final SupplierXmiClasspathScanner<DataCatalog> scanner = new SupplierXmiClasspathScanner<DataCatalog>(DataPackage.eINSTANCE, DataCatalog.class,
				aggregator, DataConfig.class.getClassLoader(), dataFolder);
		return aggregator;
	}
	
//	@Bean @Lazy(false)
//	public SupplierXmiClasspathScanner<DataCatalog> builtinDataCatalogsScanner() {
//		return new SupplierXmiClasspathScanner<DataCatalog>(DataPackage.eINSTANCE, DataCatalog.class,
//				dataCatalogSupplier(), DataConfig.class);
//	}
	
	@Bean
	public DataCatalog dataCatalog() {
		return dataCatalogSupplier().get();
	}

	@Bean
	public MixinManager mixinMgr() {
		return new MixinManagerImpl(dataCatalog());
	}
	
	@Bean
	public TermManager termMgr() {
		return new TermManagerImpl(dataCatalog());
	}
	
}
