package org.soluvas.commons.shell;

import java.lang.annotation.Annotation;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Qualifier;

import org.apache.felix.service.command.CommandSession;
import org.apache.karaf.shell.console.AbstractAction;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.ShellProgressMonitor;
import org.soluvas.commons.impl.ShellProgressMonitorImpl;
import org.soluvas.commons.locale.LocaleContext;
import org.soluvas.commons.tenant.CommandRequestAttributes;
import org.soluvas.commons.tenant.RequestOrCommandScope;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantRefImpl;
import org.soluvas.commons.util.ThreadLocalProgress;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.core.NamedThreadLocal;
import org.springframework.core.env.Environment;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * {@link AbstractAction} base class for Blast Shell commands.
 * @author ceefour
 * @see RequestOrCommandScope
 * @see CommandRequestAttributes
 */
public abstract class ExtCommandSupport extends AbstractAction {

//	protected static final ThreadLocal<CommandSession> threadCommandSession = new NamedThreadLocal<>("CommandSession");
	protected static final ThreadLocal<CommandRequestAttributes> threadRequestAttributes = new NamedThreadLocal<>("Command RequestAttributes");
	/**
	 * @todo Proper locale support.
	 */
	protected static final LocaleContext localeContext = new LocaleContext();
	protected final ShellProgressMonitor monitor = new ShellProgressMonitorImpl();
	@Inject
	protected ListableBeanFactory beanFactory;
	@Inject
	private Environment env;
	@Resource(name="tenantMap")
	private Map<String, AppManifest> tenantMap;
	
	@Override
	public Object execute(CommandSession session) throws Exception {
		final CommandRequestAttributes reqAttrs = new CommandRequestAttributes(session);
		try {
//			threadCommandSession.set(session);
			threadRequestAttributes.set(reqAttrs);
			try (ThreadLocalProgress progress = new ThreadLocalProgress(monitor)) {
				return super.execute(session);
			}
		} finally {
			// Subclasses usually forget to do this, so we'll do this for them :)
			System.out.flush();
			System.err.flush();
			// Mark "request" as completed
			reqAttrs.requestCompleted();
			threadRequestAttributes.remove();
//			threadCommandSession.remove();
		}
	}
	
	/**
	 * Gets the current thread's {@link CommandSession}.
	 * @return
	 * @throws IllegalStateException
	 */
//	public static CommandSession currentCommandSession() throws IllegalStateException {
//		final CommandSession session = threadCommandSession.get();
//		Preconditions.checkState(session != null, "Not in CommandSession");
//		return session;
//	}
	
	/**
	 * Gets the current thread's {@link CommandRequestAttributes}.
	 * @return
	 * @throws IllegalStateException
	 */
	public static CommandRequestAttributes currentRequestAttributes() throws IllegalStateException {
		final CommandRequestAttributes requestAttributes = threadRequestAttributes.get();
		Preconditions.checkState(requestAttributes != null, "Not in CommandSession");
		return requestAttributes;
	}
	
	/**
	 * Tenant for the currently executing {@link CommandSession}.
	 * @throws IllegalStateException If not executed inside {@link #doExecute()} / {@link CommandSession}.
	 */
	protected TenantRef getTenant() {
		Preconditions.checkState(session != null, "Must be inside CommandSession");
		final String clientId = Optional.fromNullable((String) session.get("clientId")).or(tenantMap.keySet().iterator().next());
		final String tenantId = Optional.fromNullable((String) session.get("tenantId")).or(tenantMap.keySet().iterator().next());
		final String tenantEnv = env.getRequiredProperty("tenantEnv");
		return new TenantRefImpl(clientId, tenantId, tenantEnv);
	}
	
	/**
	 * Set the current clientId.
	 * @param clientId
	 * @see #getTenant()
	 * @throws IllegalArgumentException if not a known tenantId in {@code tenantMap}
	 */
	protected void setClientId(String clientId) {
		// TODO: Concept of 'clientId' is currently unused and ambiguous
		Preconditions.checkState(session != null, "Must be inside CommandSession");
		Preconditions.checkArgument(tenantMap.keySet().contains(clientId),
				"Unknown clientId '%s', %s valid tenantIds are: %s",
				clientId, tenantMap.size(), tenantMap.keySet());
		session.put("clientId", clientId);
	}
	
	/**
	 * Set the current tenantId.
	 * @param tenantId
	 * @see #getTenant()
	 * @throws IllegalArgumentException if not a known tenantId in {@code tenantMap}
	 */
	protected void setTenantId(String tenantId) {
		Preconditions.checkState(session != null, "Must be inside CommandSession");
		Preconditions.checkArgument(tenantMap.keySet().contains(tenantId),
				"Unknown tenantId '%s', %s valid tenantIds are: %s",
				tenantId, tenantMap.size(), tenantMap.keySet());
		session.put("tenantId", tenantId);
	}
	
	/**
	 * Return the tenant-scoped bean of type T, without {@link Qualifier} support.
	 * First it looks up the bean named {@code requiredType + "Map"} which must be a {@link Map},
	 * then it looks up the key based on {@link TenantRef#getTenantId()} and returns that object. 
	 * @param requiredType
	 * @return
	 */
	protected <T> T getBean(Class<T> requiredType) {
		// TODO: implement as the Javadoc says
		return beanFactory.getBean(requiredType);
	}

	/**
	 * Return all beans of type T, without {@link Qualifier} support.
	 * @param requiredType
	 * @return
	 */
	protected <T> Map<String, T> getBeans(Class<T> requiredType) {
		return beanFactory.getBeansOfType(requiredType);
	}

	/**
	 * Return the tenant-scoped bean of type T, with {@link Qualifier} support.
	 * First it looks up the bean named {@code qualifier + requiredType + "Map"} which must be a {@link Map},
	 * then it looks up the key based on {@link TenantRef#getTenantId()} and returns that object. 
	 * @param requiredType
	 * @return
	 */
	protected <T> T getBean(Class<T> requiredType, Class<? extends Annotation> qualifier) {
		// TODO: implement as the Javadoc says
		final Map<String, Object> beans = beanFactory.getBeansWithAnnotation(qualifier);
		if (beans.isEmpty()) throw new NoSuchBeanDefinitionException(requiredType, "With qualifier " + qualifier.getName(), "Cannot find bean");
		if (beans.size() > 1) throw new NoUniqueBeanDefinitionException(requiredType, beans.keySet());
		return (T) beans.values().iterator().next();
	}
	
}
