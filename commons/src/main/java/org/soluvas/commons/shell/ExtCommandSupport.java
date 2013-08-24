package org.soluvas.commons.shell;

import java.lang.annotation.Annotation;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Qualifier;

import org.apache.felix.service.command.CommandSession;
import org.apache.karaf.shell.console.AbstractAction;
import org.soluvas.commons.ShellProgressMonitor;
import org.soluvas.commons.impl.ShellProgressMonitorImpl;
import org.soluvas.commons.locale.LocaleContext;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.util.ThreadLocalProgress;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

/**
 * @author agus
 *
 */
public abstract class ExtCommandSupport extends AbstractAction {

	/**
	 * Tenant for the currently executing {@link CommandSession}.
	 * May be {@literal null} if no session is executing.
	 */
//	protected TenantRef tenant;
	/**
	 * @todo Proper locale support.
	 */
	protected LocaleContext localeContext = new LocaleContext();
	protected ShellProgressMonitor monitor = new ShellProgressMonitorImpl();
	@Inject
	protected ListableBeanFactory beanFactory;
	
	@Override
	public Object execute(CommandSession session) throws Exception {
		try (ThreadLocalProgress progress = new ThreadLocalProgress(monitor)) {
			return super.execute(session);
		}
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
