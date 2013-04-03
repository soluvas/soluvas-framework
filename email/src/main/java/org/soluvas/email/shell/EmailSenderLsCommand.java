package org.soluvas.email.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NameUtils;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.SenderType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;

/**
 * List registered {@link SenderType}s.
 * @author ceefour
 */
@Service @Lazy
@Command(scope="email", name="senderls", description="List registered SenderTypes.")
public class EmailSenderLsCommand extends OsgiCommandSupport {
	
	private final EmailCatalog emailCatalog;
	
	@Inject
	public EmailSenderLsCommand(EmailCatalog emailCatalog) {
		super();
		this.emailCatalog = emailCatalog;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractSender#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
//		final ServiceReference<EmailCatalog> emailCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(EmailCatalog.class),
//				"Cannot get %s service reference", EmailCatalog.class.getName());
//		final EmailCatalog emailCatalog = Preconditions.checkNotNull(getService(EmailCatalog.class, emailCatalogRef),
//				"Cannot get %s service", EmailCatalog.class.getName());
		System.out.println(ansi().render("@|negative_on %3s|%-20s|%-10s|%-25s|%-25s|%-20s|%-20s|@",
				"№", "Sender", "Catalog", "From", "Email", "Features", "Bundle"));
		int i = 0;
		for (final SenderType senderType : emailCatalog.getSenderTypes()) {
			final String bundleAnsi = NameUtils.shortenBundleAnsi(senderType.getBundle(), 20);
//			final String classNameAnsi = NameUtils.shortenClassAnsi(senderType.getJavaClassName(), 25);
			
			final EClass typeEClass = EmailPackage.Literals.SENDER_TYPE;
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
			System.out.println(ansi().render(
					"@|bold,black %3d||@@|bold %-20s|@@|bold,black ||@%-10s@|bold,black ||@%-25s@|bold,black ||@%-25s@|bold,black ||@%-25s@|bold,black ||@" + bundleAnsi,
				++i, senderType.getName(), senderType.getNsPrefix(),
				NameUtils.shortenMustache(senderType.getFrom()), NameUtils.shortenMustache(senderType.getEmail()),
				Joiner.on(' ').join(featureNames) ));
		}
		System.out.println(ansi().render("@|bold %d|@ senderTypes", i));
		return null;
	}

}
