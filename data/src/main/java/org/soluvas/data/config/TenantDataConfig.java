package org.soluvas.data.config;

import java.io.File;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AggregatingSupplier;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.SupplierXmiClasspathScanner;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.MixinCatalog;
import org.soluvas.data.MixinManager;
import org.soluvas.data.TermManager;
import org.soluvas.data.impl.DataCatalogImpl;
import org.soluvas.data.impl.MixinCatalogImpl;
import org.soluvas.data.impl.MixinManagerImpl;
import org.soluvas.data.impl.TermManagerImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;

/**
 * Multitenant-aware {@link Configuration} for {@link DataCatalog}, {@link MixinCatalog}, and {@link TermManager} beans.
 * @author rudi
 */
@Configuration
@ComponentScan("org.soluvas.data.shell")
public class TenantDataConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(TenantDataConfig.class);
	
	@Inject
	private BeanFactory beanFactory;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject
	private TenantSelector tenantSelector;
	
	@Bean
	public TenantBeans<DataCatalog> dataCatalogBeans() {
		return new TenantBeans<DataCatalog>(DataCatalogImpl.class) {
			@Override
			protected DataCatalogImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final File dataDir = tenantConfig.dataDirMap().get(tenantId);
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
				final DataCatalogImpl dataCatalog = (DataCatalogImpl) aggregator.get();
				return dataCatalog;
			}
		};
	}
	
	@Bean @Scope("prototype")
	public DataCatalog dataCatalog() {
		return dataCatalogBeans().get(tenantSelector.tenantRef().getTenantId());
	}
	
	@Bean
	public TenantBeans<MixinCatalog> mixinCatalogBeans() {
		return new TenantBeans<MixinCatalog>(MixinCatalogImpl.class) {
			@Override
			protected MixinCatalogImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final File dataDir = tenantConfig.dataDirMap().get(tenantId);
				final File tenantMixinCatalogFile = new File(dataDir, "common/base.MixinCatalog.xmi");
				Supplier<MixinCatalog> supplier;
				if (tenantMixinCatalogFile.exists()) {
					// If tenant-specific MixinCatalog exists, use it
					log.info("Using tenant-specific MixinCatalog from {}", tenantMixinCatalogFile);
					supplier = new OnDemandXmiLoader<>(DataPackage.eINSTANCE, tenantMixinCatalogFile.getAbsoluteFile());
				} else {
					// otherwise, use default MixinCatalog
					// TODO: don't hardcode default mixin classpath name, or it should be in src/main/resources/META-INF
					log.info("Using app MixinCatalog from {}", tenantMixinCatalogFile);
					try {
						supplier = new OnDemandXmiLoader<>(DataPackage.eINSTANCE, TenantDataConfig.class, 
								"/id/co/bippo/common/base.MixinCatalog.xmi");
					} catch (Exception e) {
						log.info("App MixinCatalog not found: " + tenantMixinCatalogFile, e);
						supplier = Suppliers.ofInstance(DataFactory.eINSTANCE.createMixinCatalog());
					}
				}
				final MixinCatalogImpl mixinCatalog = (MixinCatalogImpl) supplier.get();
				return mixinCatalog;
			}
		};
	}
	
	@Bean @Scope("prototype")
	public MixinCatalog mixinCatalog() {
		return mixinCatalogBeans().get(tenantSelector.tenantRef().getTenantId());
	}
	
	@Bean
	public TenantBeans<MixinManager> mixinMgrBeans() {
		return new TenantBeans<MixinManager>(MixinManagerImpl.class) {
			@Override
			protected MixinManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final MixinCatalog mixinCatalog = mixinCatalogBeans().get(tenantId);
				final MixinManagerImpl mixinMgr = new MixinManagerImpl(mixinCatalog);
				return mixinMgr;
			}
		};
	}
	
	@Bean @Scope("prototype")
	public MixinManager mixinMgr() {
		return mixinMgrBeans().get(tenantSelector.tenantRef().getTenantId());
	}
	
	@Bean
	public TenantBeans<TermManager> termMgrBeans() {
		return new TenantBeans<TermManager>(TermManagerImpl.class) {
			@Override
			protected TermManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final DataCatalog dataCatalog = dataCatalogBeans().get(tenantId);
				final TermManagerImpl termMgr = new TermManagerImpl(dataCatalog);
				return termMgr;
			}
		};
	}
	
	@Bean @Scope("prototype")
	public TermManager termMgr() {
		return termMgrBeans().get(tenantSelector.tenantRef().getTenantId());
	}
	
//	@Bean @Lazy(false)
//	public SupplierXmiClasspathScanner<DataCatalog> builtinDataCatalogsScanner() {
//		return new SupplierXmiClasspathScanner<DataCatalog>(DataPackage.eINSTANCE, DataCatalog.class,
//				dataCatalogSupplier(), DataConfig.class);
//	}
	
}
