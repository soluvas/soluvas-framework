package org.soluvas.jpa;

import javax.annotation.Nullable;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.soluvas.commons.tenant.RequestOrCommandScope;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.web.context.request.RequestAttributes;

import com.google.common.base.Preconditions;

/**
 * Uses {@link RequestOrCommandScope}.
 * @author ceefour
 */
public class SoluvasTenantIdentifierResolver implements
		CurrentTenantIdentifierResolver {

	/* (non-Javadoc)
	 * @see org.hibernate.context.spi.CurrentTenantIdentifierResolver#resolveCurrentTenantIdentifier()
	 */
	@Override @Nullable
	public String resolveCurrentTenantIdentifier() {
		final RequestAttributes attributes = RequestOrCommandScope.currentRequestAttributes();
		final TenantRef tenantRef = Preconditions.checkNotNull((TenantRef) attributes.getAttribute("tenantRef", RequestAttributes.SCOPE_REQUEST),
				"Cannot get 'tenantRef' SCOPE_REQUEST attribute from RequestAttributes");
		return tenantRef.getTenantId();
	}

	/* (non-Javadoc)
	 * @see org.hibernate.context.spi.CurrentTenantIdentifierResolver#validateExistingCurrentSessions()
	 */
	@Override
	public boolean validateExistingCurrentSessions() {
		return resolveCurrentTenantIdentifier() != null;
	}

}
