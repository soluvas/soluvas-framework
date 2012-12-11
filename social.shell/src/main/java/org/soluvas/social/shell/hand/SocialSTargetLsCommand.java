package org.soluvas.social.shell.hand;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.social.SocialPackage;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;

/**
 * List registered {@link TargetType}s.
 * @author ceefour
 */
@Command(scope="socials", name="targetls", description="List registered TargetTypes.")
public class SocialSTargetLsCommand extends OsgiCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractTarget#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<SocialSchemaCatalog> storySchemaCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(SocialSchemaCatalog.class),
				"Cannot get %s service reference", SocialSchemaCatalog.class.getName());
		final SocialSchemaCatalog storySchemaCatalog = Preconditions.checkNotNull(getService(SocialSchemaCatalog.class, storySchemaCatalogRef),
				"Cannot get %s service", SocialSchemaCatalog.class.getName());
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-10s|%-30s|%-34s|@",
				"№", "Target", "Catalog", "Attributes", "Bundle"));
		int i = 0;
		for (final TargetType targetType : storySchemaCatalog.getTargetTypes()) {
			final Bundle bundle = targetType.getBundle();
//			final String classNameAnsi = NameUtils.shortenClassAnsi(targetType.getJavaClassName(), 25);
			final EClass targetTypeEClass = targetType.getEClass();
			final Set<String> builtinAttrNames = ImmutableSet.of(
					CommonsPackage.Literals.NS_PREFIXABLE__NS_PREFIX.getName(),
					SocialPackage.Literals.TARGET__TYPE_NAME.getName(),
					SocialPackage.Literals.TARGET__TITLE.getName(),
					SocialPackage.Literals.TARGET__URI.getName(),
					SocialPackage.Literals.TARGET__IMAGES.getName()); 
			// for some reason won't work:
//			final Set<EAttribute> attrs = Sets.difference(ImmutableSet.copyOf(targetTypeEClass.getEAllAttributes()), builtinAttrs);
			final Collection<EAttribute> attrs = Collections2.filter(targetTypeEClass.getEAllAttributes(), new Predicate<EAttribute>() {
				@Override
				public boolean apply(@Nullable EAttribute input) {
					return !builtinAttrNames.contains(input.getName());
				}
			});
			final Collection<String> attrNames = Collections2.transform(attrs, new Function<EAttribute, String>() {
				@Override @Nullable
				public String apply(@Nullable EAttribute attr) {
					return attr.getName();
				}
			});
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-15s|@@|bold,black ||@%-10s@|bold,black ||@%-30s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, targetType.getName(), targetType.getResourceName(), Joiner.on(' ').join(attrNames),
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ targetTypes", i));
		return null;
	}

}
