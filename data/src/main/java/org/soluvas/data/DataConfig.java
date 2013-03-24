package org.soluvas.data;

import java.util.ArrayList;
import java.util.List;

import org.soluvas.commons.AggregatingSupplier;
import org.soluvas.commons.DelegatingSupplier;
import org.soluvas.commons.SupplierXmiClasspathScanner;
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
@Configuration
public class DataConfig {
	
	@Bean
	public DelegatingSupplier<DataCatalog> dataCatalogSupplier() {
		return new AggregatingSupplier<DataCatalog>(DataFactory.eINSTANCE,
				DataPackage.Literals.DATA_CATALOG, ImmutableList.<Supplier<DataCatalog>>of());
	}
	
	@Bean @Lazy(false)
	public SupplierXmiClasspathScanner<DataCatalog> builtinDataCatalogsScanner() {
		return new SupplierXmiClasspathScanner<DataCatalog>(DataPackage.eINSTANCE, DataCatalog.class,
				dataCatalogSupplier(), DataConfig.class);
	}
	
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
