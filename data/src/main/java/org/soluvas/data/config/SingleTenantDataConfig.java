package org.soluvas.data.config;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AggregatingSupplier;
import org.soluvas.commons.DataFolder;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.SupplierXmiClasspathScanner;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.MixinCatalog;
import org.soluvas.data.MixinManager;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.PropertyDefinitionRepositoryImpl;
import org.soluvas.data.TermChanged;
import org.soluvas.data.TermManager;
import org.soluvas.data.impl.MixinManagerImpl;
import org.soluvas.data.impl.TermManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * <p><strong>Note:</strong> It's recommended to use multitenant {@link TenantDataConfig} to make your application future-proof.
 * @author rudi
 */
@Configuration
@ComponentScan("org.soluvas.data.shell")
public class SingleTenantDataConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(SingleTenantDataConfig.class);
	@Inject @DataFolder
	private String dataFolder;
	@Inject
	private EventBus eventBus;
	
	@Bean
	public AggregatingSupplier<DataCatalog> dataCatalogSupplier() {
		// Note: If you get an error here, please delete "base-mixin.DataCatalog.xmi", for 5.2
		// it has been replaced with "base.MixinCatalog.xmi" and loaded by mixinCatalog()
		final AggregatingSupplier<DataCatalog> aggregator = new AggregatingSupplier<>(DataFactory.eINSTANCE,
				DataPackage.Literals.DATA_CATALOG, ImmutableList.<Supplier<DataCatalog>>of());
		final SupplierXmiClasspathScanner<DataCatalog> scanner = new SupplierXmiClasspathScanner<>(DataPackage.eINSTANCE, DataCatalog.class,
				aggregator, SingleTenantDataConfig.class.getClassLoader(), dataFolder);
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
	public TermManager termMgr() {
		return new TermManagerImpl(dataCatalog());
	}
	
	@Bean
	public MixinCatalog mixinCatalog() {
		final File tenantMixinCatalogFile = new File(dataFolder, "common/base.MixinCatalog.xmi");
		final Supplier<MixinCatalog> supplier;
		if (tenantMixinCatalogFile.exists()) {
			// If tenant-specific MixinCatalog exists, use it
			log.info("Using tenant-specific MixinCatalog from {}", tenantMixinCatalogFile);
			supplier = new OnDemandXmiLoader<>(DataPackage.eINSTANCE, tenantMixinCatalogFile.getAbsoluteFile());
		} else {
			// otherwise, use default MixinCatalog
			// TODO: don't hardcode default mixin classpath name
			log.info("Using default MixinCatalog from {}", tenantMixinCatalogFile);
			supplier = new OnDemandXmiLoader<>(DataPackage.eINSTANCE, SingleTenantDataConfig.class, 
					"/id/co/bippo/common/base.MixinCatalog.xmi");
		}
		return supplier.get();
	}

	@Bean
	public MixinManager mixinMgr() {
		return new MixinManagerImpl(mixinCatalog());
	}
	
	@PostConstruct
	public void registerSubscriber() {
		eventBus.register(this);
	}
	
	@PreDestroy
	public void unregisterSubscriber() {
		if (eventBus != null) {
			eventBus.unregister(this);
		}
	}
	
	@Subscribe
	public void reloadDataCatalog(TermChanged ev) {
		log.info("Reloading aggregated DataCatalog due to {}", ev);
		dataCatalogSupplier().reload();
	}
	
	
	@Bean
	public PropertyDefinitionRepository propertyDefinitionRepo() {
		return new PropertyDefinitionRepositoryImpl();
	}
}
