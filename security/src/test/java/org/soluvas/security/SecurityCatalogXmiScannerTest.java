package org.soluvas.security;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.soluvas.commons.AggregatingSupplier;
import org.soluvas.commons.SupplierXmiClasspathScanner;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * Tests common AppConfig configuration, e.g.:
 * 
 * <pre>
 * @Bean @Lazy
 * public SecurityCatalog securityCatalog() {
 * 	final AggregatingSupplier&lt;SecurityCatalog> aggregatingSupplier = new AggregatingSupplier&lt;>(SecurityFactory.eINSTANCE,
 * 			SecurityPackage.Literals.SECURITY_CATALOG, ImmutableList.&lt;Supplier&lt;SecurityCatalog>>of());
 * 	new SupplierXmiClasspathScanner&lt;>(SecurityPackage.eINSTANCE, SecurityCatalog.class, aggregatingSupplier, 
 * 			SecurityConfig.class.getClassLoader(), dataFolder);
 * 	final SecurityCatalog securityCatalog = aggregatingSupplier.get();
 * 	securityCatalog.validate();
 * 	return securityCatalog;
 * }
 * 
 * @Bean
 * public CatalogRoleRepository roleRepo() {
 * 	final CatalogRoleRepository roleRepo = new CatalogRoleRepository(securityCatalog());
 * 	// sanity check
 * 	Preconditions.checkState(roleRepo.exists("sysadmin"),
 * 			"Security Role 'sysadmin' must exist. Check your SecurityCatalog (XMI) configuration!");
 * 	Preconditions.checkState(roleRepo.exists("admin"),
 * 			"Security Role 'admin' must exist. Check your SecurityCatalog (XMI) configuration!");
 * 	return roleRepo;
 * }
 * </pre>
 * 
 * 
 * @author rudi
 */
public class SecurityCatalogXmiScannerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void withoutDataDir() {
		final AggregatingSupplier<SecurityCatalog> aggregatingSupplier = new AggregatingSupplier<>(SecurityFactory.eINSTANCE,
				SecurityPackage.Literals.SECURITY_CATALOG, ImmutableList.<Supplier<SecurityCatalog>>of());
		new SupplierXmiClasspathScanner<>(SecurityPackage.eINSTANCE, SecurityCatalog.class, aggregatingSupplier, 
				SecurityCatalogXmiScannerTest.class.getClassLoader());
		final SecurityCatalog securityCatalog = aggregatingSupplier.get();
		securityCatalog.validate();
		assertThat(securityCatalog.getRoles(), hasSize(4));
	}

	@Test
	public void tuneeca53DataDir() {
		final File dataDir = new File(System.getProperty("user.home"), "tuneeca_dev");
		final AggregatingSupplier<SecurityCatalog> aggregatingSupplier = new AggregatingSupplier<>(SecurityFactory.eINSTANCE,
				SecurityPackage.Literals.SECURITY_CATALOG, ImmutableList.<Supplier<SecurityCatalog>>of());
		new SupplierXmiClasspathScanner<>(SecurityPackage.eINSTANCE, SecurityCatalog.class, aggregatingSupplier, 
				SecurityCatalogXmiScannerTest.class.getClassLoader(), dataDir);
		final SecurityCatalog securityCatalog = aggregatingSupplier.get();
		securityCatalog.validate();
		assertThat(securityCatalog.getRoles(), hasSize(greaterThanOrEqualTo(4)));
	}

	@Test
	public void tuneeca54DataDir() {
		final File dataDir = new File(System.getProperty("user.home"), "bipporeg_commerce_dev/tuneeca");
		final AggregatingSupplier<SecurityCatalog> aggregatingSupplier = new AggregatingSupplier<>(SecurityFactory.eINSTANCE,
				SecurityPackage.Literals.SECURITY_CATALOG, ImmutableList.<Supplier<SecurityCatalog>>of());
		new SupplierXmiClasspathScanner<>(SecurityPackage.eINSTANCE, SecurityCatalog.class, aggregatingSupplier, 
				SecurityCatalogXmiScannerTest.class.getClassLoader(), dataDir);
		final SecurityCatalog securityCatalog = aggregatingSupplier.get();
		securityCatalog.validate();
		assertThat(securityCatalog.getRoles(), hasSize(greaterThanOrEqualTo(4)));
	}

}
