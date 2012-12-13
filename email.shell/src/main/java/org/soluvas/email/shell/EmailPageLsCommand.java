package org.soluvas.email.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.PageType;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;

/**
 * List registered {@link PageType}s.
 * @author ceefour
 */
@Command(scope="email", name="pagels", description="List registered PageTypes.")
public class EmailPageLsCommand extends OsgiCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractPage#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<EmailCatalog> emailCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(EmailCatalog.class),
				"Cannot get %s service reference", EmailCatalog.class.getName());
		final EmailCatalog emailCatalog = Preconditions.checkNotNull(getService(EmailCatalog.class, emailCatalogRef),
				"Cannot get %s service", EmailCatalog.class.getName());
		System.out.println(ansi().render("@|negative_on %3s|%-22s|%-10s|%-25s|%-20s|%-20s|%-34s|@",
				"№", "Page", "Catalog", "Features", "Subject", "Template", "Bundle"));
		int i = 0;
		for (final PageType pageType : emailCatalog.getPageTypes()) {
			final Bundle bundle = pageType.getBundle(); // TODO: Use BundleAware, and either use bridge pattern or merge into one class
//			final String classNameAnsi = NameUtils.shortenClassAnsi(pageType.getJavaClassName(), 25);
			
			final EClass typeEClass = pageType.getEClass();
			final Set<String> builtinAttrNames = ImmutableSet.of(
					CommonsPackage.Literals.NS_PREFIXABLE__NS_PREFIX.getName() );
			
			// for some reason won't work:
//			final Set<EAttribute> attrs = Sets.difference(ImmutableSet.copyOf(targetTypeEClass.getEAllAttributes()), builtinAttrs);
			final Collection<EStructuralFeature> attrs = Collections2.filter(typeEClass.getEAllStructuralFeatures(), new Predicate<EStructuralFeature>() {
				@Override
				public boolean apply(@Nullable EStructuralFeature input) {
					return !builtinAttrNames.contains(input.getName());
				}
			});
			final Collection<String> featureNames = Collections2.transform(attrs, new Function<EStructuralFeature, String>() {
				@Override @Nullable
				public String apply(@Nullable EStructuralFeature feature) {
					return feature.getName();
				}
			});
			
			final String subject = pageType.getSubjectTemplate().substring(0, 20);
			final String template = pageType.getPlainTemplate().substring(0, 20);
			
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-22s|@@|bold,black ||@%-10s@|bold,black ||@%-25s@|bold,black ||@%-20s@|bold,black ||@%-20s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, pageType.getName(), pageType.getResourceName(),
				Joiner.on(' ').join(featureNames),
				subject, template,
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ pageTypes", i));
		return null;
	}

}
