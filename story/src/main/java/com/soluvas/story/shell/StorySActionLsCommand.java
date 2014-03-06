package com.soluvas.story.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Bundle;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NameFunction;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.ActionTypeStatus;
import com.soluvas.story.schema.SchemaPackage;
import com.soluvas.story.schema.StorySchemaCatalog;

/**
 * List registered {@link ActionType}s.
 * @author ceefour
 */
@Service @Lazy
@Command(scope="storys", name="actionls", description="List registered ActionTypes.")
public class StorySActionLsCommand extends ExtCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final StorySchemaCatalog storySchemaCatalog = getBean(StorySchemaCatalog.class);
		
//		final ServiceReference<StorySchemaCatalog> storySchemaCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(StorySchemaCatalog.class),
//				"Cannot get %s service reference", StorySchemaCatalog.class.getName());
//		final StorySchemaCatalog storySchemaCatalog = Preconditions.checkNotNull(getService(StorySchemaCatalog.class, storySchemaCatalogRef),
//				"Cannot get %s service", StorySchemaCatalog.class.getName());
		System.out.println(ansi().render("@|negative_on %3s|%-10s|%-10s|%-25s|%-20s|%-20s|@",
				"№", "Action", "Catalog", "Subjects", "Attributes", "Bundle"));
		int i = 0;
		for (final ActionType actionType : storySchemaCatalog.getActionTypes()) {
			final Bundle bundle = actionType.getBundle();
//			final String classNameAnsi = NameUtils.shortenClassAnsi(actionType.getJavaClassName(), 25);
			final List<String> subjectNames = Lists.transform(actionType.getSubjectTypes(), new NameFunction());
			
			final EClass targetTypeEClass = actionType.getEClass();
			final Set<String> builtinAttrNames = ImmutableSet.of(
					CommonsPackage.Literals.NS_PREFIXABLE__NS_PREFIX.getName(),
					SchemaPackage.Literals.ACTION_LIKE__IMPERATIVE_TENSE.getName(),
					SchemaPackage.Literals.ACTION_LIKE__PAST_TENSE.getName(),
					SchemaPackage.Literals.ACTION_LIKE__PLURAL_PAST_TENSE.getName(),
					SchemaPackage.Literals.ACTION_LIKE__PLURAL_PRESENT_TENSE.getName(),
					SchemaPackage.Literals.ACTION_LIKE__PRESENT_TENSE.getName(),
					SchemaPackage.Literals.ACTION_LIKE__TENSES.getName() );
			final String stateSymbol = actionType.getStatus() == ActionTypeStatus.RESOLVED ? "@|bold,green ▶|@" : "@|bold,red ✖|@";  
			
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
			final String bundleAnsi = NameUtils.shortenBundleAnsi(bundle, 20);
			System.out.println(ansi().render("@|bold,black %3d||@" + stateSymbol + "@|bold %-9s|@@|bold,black ||@%-10s@|bold,black ||@%-25s@|bold,black ||@%-20s@|bold,black ||@" + bundleAnsi,
				++i, actionType.getName(), actionType.getResourceName(), Joiner.on(' ').join(subjectNames),
				Joiner.on(' ').join(attrNames) ));
		}
		System.out.println(ansi().render("@|bold %d|@ actionTypes", i));
		return null;
	}

}
