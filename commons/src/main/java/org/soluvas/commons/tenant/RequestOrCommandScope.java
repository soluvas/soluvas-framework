package org.soluvas.commons.tenant;

import org.apache.felix.service.command.CommandSession;
import org.soluvas.commons.config.MultiTenantWebConfig;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;

/**
 * Enhanced {@link RequestScope} that also works inside a {@link CommandSession},
 * i.e. by simulating a command invocation as a web request.
 * @author ceefour
 * @see MultiTenantWebConfig#tenantRef()
 * @see CommandRequestAttributes
 * @see ExtCommandSupport
 */
public class RequestOrCommandScope implements Scope {

	/**
	 * Return the RequestAttributes currently bound to the thread.
	 * Will call {@link RequestContextHolder#currentRequestAttributes()}
	 * first, if fails then uses the {@link ExtCommandSupport} {@link CommandRequestAttributes}.
	 * 
	 * <p>Exposes the previously bound RequestAttributes instance, if any.
	 * 
	 * <p>Activation: use with {@code org.soluvas.web.site.AppInitializer}.
	 * 
	 * @return the RequestAttributes currently bound to the thread
	 * @throws IllegalStateException if no RequestAttributes object
	 * is bound to the current thread
	 * @see RequestContextHolder#currentRequestAttributes()
	 */
	public static RequestAttributes currentRequestAttributes() throws IllegalStateException {
		try {
			return RequestContextHolder.currentRequestAttributes();
		} catch (IllegalStateException e) {
			return CommandRequestAttributes.currentRequestAttributes();
		}
	}

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		RequestAttributes attributes = RequestOrCommandScope.currentRequestAttributes();
		Object scopedObject = attributes.getAttribute(name, getScope());
		if (scopedObject == null) {
			scopedObject = objectFactory.getObject();
			attributes.setAttribute(name, scopedObject, getScope());
		}
		return scopedObject;
	}

	@Override
	public Object remove(String name) {
		RequestAttributes attributes = RequestOrCommandScope.currentRequestAttributes();
		Object scopedObject = attributes.getAttribute(name, getScope());
		if (scopedObject != null) {
			attributes.removeAttribute(name, getScope());
			return scopedObject;
		}
		else {
			return null;
		}
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		RequestAttributes attributes = RequestOrCommandScope.currentRequestAttributes();
		attributes.registerDestructionCallback(name, callback, getScope());
	}

	@Override
	public Object resolveContextualObject(String key) {
		RequestAttributes attributes = RequestOrCommandScope.currentRequestAttributes();
		return attributes.resolveReference(key);
	}

	/**
	 * Template method that determines the actual target scope.
	 * @return the target scope, in the form of an appropriate
	 * {@link RequestAttributes} constant
	 * @see RequestAttributes#SCOPE_REQUEST
	 * @see RequestAttributes#SCOPE_SESSION
	 * @see RequestAttributes#SCOPE_GLOBAL_SESSION
	 */
	protected int getScope() {
		return RequestAttributes.SCOPE_REQUEST;
	}

	@Override
	public String getConversationId() {
		return null;
	}

}
