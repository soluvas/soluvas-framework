package org.soluvas.jpa;

import javax.annotation.Nullable;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.RequestOrCommandScope;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;

/**
 * Uses {@link RequestOrCommandScope}.
 * @see SoluvasMultiTenantConnectionProviderImpl
 * @author ceefour
 */
public class SoluvasTenantIdentifierResolver implements
		CurrentTenantIdentifierResolver {

	private static final Logger log = LoggerFactory
			.getLogger(SoluvasTenantIdentifierResolver.class);
	public static ApplicationContext appCtx;

	/* (non-Javadoc)
	 * @see org.hibernate.context.spi.CurrentTenantIdentifierResolver#resolveCurrentTenantIdentifier()
	 */
	@Override @Nullable
	public String resolveCurrentTenantIdentifier() {
		try {
			final TenantRef tenantRef = appCtx.getBean(TenantRef.class);
			log.trace("Resolved current tenant: {}", tenantRef.getTenantId());
//			final RequestAttributes requestAttrs = RequestOrCommandScope.currentRequestAttributes();
//			final TenantRef tenantRef = Preconditions.checkNotNull((TenantRef) requestAttrs.resolveReference("tenantRef"),
//					"Cannot resolve 'tenantRef' attribute from RequestAttributes");
//			final Set<String> attributeNames = ImmutableSet.copyOf(requestAttrs.getAttributeNames(RequestAttributes.SCOPE_REQUEST));
//			final TenantRef tenantRef = Preconditions.checkNotNull((TenantRef) requestAttrs.getAttribute("tenantRef", RequestAttributes.SCOPE_REQUEST),
//					"Cannot get 'tenantRef' SCOPE_REQUEST attribute from RequestAttributes, known attribute names: %s", attributeNames);
			return tenantRef.getTenantId();
		} catch (IllegalStateException | BeanCreationException e) {
			log.trace("Not resolving current tenant: " + e, e);
			// not in request or command scope
			return "public";
		}
	}

	/* (non-Javadoc)
	 * @see org.hibernate.context.spi.CurrentTenantIdentifierResolver#validateExistingCurrentSessions()
	 */
	@Override
	public boolean validateExistingCurrentSessions() {
		return resolveCurrentTenantIdentifier() != null;
	}

}
