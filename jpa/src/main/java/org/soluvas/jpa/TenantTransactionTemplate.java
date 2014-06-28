package org.soluvas.jpa;

import java.io.Closeable;
import java.io.IOException;

import javax.persistence.PersistenceException;

import org.soluvas.commons.tenant.CommandRequestAttributes;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * {@link TransactionTemplate} with multitenant support.
 * Since we can't just use @Transactional because we need to enclose it within session
 * <b>before</b> the transaction is started (that's when it calls {@link SoluvasTenantIdentifierResolver#resolveCurrentTenantIdentifier()}).
 * @author ceefour
 */
public class TenantTransactionTemplate extends TransactionTemplate {

	private static final long serialVersionUID = 1L;

	public TenantTransactionTemplate() {
		super();
	}

	public TenantTransactionTemplate(
			PlatformTransactionManager transactionManager,
			TransactionDefinition transactionDefinition) {
		super(transactionManager, transactionDefinition);
	}

	public TenantTransactionTemplate(
			PlatformTransactionManager transactionManager) {
		super(transactionManager);
	}
	
	/**
	 * @deprecated Use {@link #execute(String, TransactionCallback)} instead.
	 */
	@Deprecated
	@Override
	public <T> T execute(TransactionCallback<T> action)
			throws TransactionException {
		return super.execute(action);
	}
	
	public <T> T execute(String tenantId, TransactionCallback<T> action) throws TransactionException {
		// We can't use @Transactional because we need to enclose it within session
		try (final Closeable closeable = CommandRequestAttributes.withTenant(tenantId)) {
			return execute(action);
		} catch (IOException e) {
			throw new CannotCreateTransactionException(
					String.format("%s» Cannot wrap transaction in session for tenant '%s': %s", 
					tenantId, tenantId, e), e); 
		} catch (PersistenceException e) {
			// helper exception to show tenantId
			throw new PersistenceException(tenantId + "» " + e.getMessage(), e);
		}
	}

}
