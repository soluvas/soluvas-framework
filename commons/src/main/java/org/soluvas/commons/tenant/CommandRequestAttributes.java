package org.soluvas.commons.tenant;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.service.command.CommandSession;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.web.context.request.AbstractRequestAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author ceefour
 *
 */
public class CommandRequestAttributes extends AbstractRequestAttributes {

//	private static final ThreadLocal<CommandRequestAttributes> commandRequestAttributes = new NamedThreadLocal<>("Command RequestAttributes");
	/**
	 * Stores the {@link RequestAttributes#SCOPE_REQUEST} attributes.
	 * Unlike in {@link CommandSession}, they will be destroyed after command execution completes. 
	 */
	private final Map<String, Object> requestVars = new HashMap<>();
	
	private final CommandSession session;
	
	public CommandRequestAttributes(CommandSession session) {
		super();
		this.session = session;
	}

	/**
	 * Return the RequestAttributes currently bound to the thread.
	 * <p>Exposes the previously bound RequestAttributes instance, if any.
	 * @return the RequestAttributes currently bound to the thread
	 * @throws IllegalStateException if no RequestAttributes object
	 * is bound to the current thread
	 * @see RequestContextHolder#currentRequestAttributes()
	 */
	public static RequestAttributes currentRequestAttributes() throws IllegalStateException {
		return ExtCommandSupport.currentRequestAttributes();
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.RequestAttributes#getAttribute(java.lang.String, int)
	 */
	@Override
	public Object getAttribute(String name, int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			return requestVars.get(name);
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			return session.get(name);
		default:
			throw new IllegalArgumentException("Unknown scope: " + scope);
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.RequestAttributes#setAttribute(java.lang.String, java.lang.Object, int)
	 */
	@Override
	public void setAttribute(String name, Object value, int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			requestVars.put(name, value);
			break;
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			session.put(name, value);
			break;
		}
	}

	@Override
	public void removeAttribute(String name, int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			requestVars.remove(name);
			break;
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			session.put(name, null);
			break;
		}
	}

	@Override
	public String[] getAttributeNames(int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			return requestVars.keySet().toArray(new String[] {});
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			return new String[] {}; // TODO: support this somehow, see https://issues.apache.org/jira/browse/FELIX-4206
		default:
			throw new IllegalArgumentException("Unknown scope: " + scope);
		}
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback,
			int scope) {
		if (scope == SCOPE_REQUEST) {
			registerRequestDestructionCallback(name, callback);
		}
		else {
			registerSessionDestructionCallback(name, callback);
		}
	}

	/**
	 * Register the given callback as to be executed after session termination.
	 * <p>Note: The callback object should be serializable in order to survive
	 * web app restarts.
	 * @param name the name of the attribute to register the callback for
	 * @param callback the callback to be executed for destruction
	 */
	protected void registerSessionDestructionCallback(String name, Runnable callback) {
//		HttpSession session = getSession(true);
//		session.setAttribute(DESTRUCTION_CALLBACK_NAME_PREFIX + name,
//				new DestructionCallbackBindingListener(callback));
	}

	
	@Override
	public Object resolveReference(String key) {
		if (REFERENCE_REQUEST.equals(key)) {
//			return this.request;
			return requestVars;
		}
		else if (REFERENCE_SESSION.equals(key)) {
			return session;
		}
		else {
			return null;
		}
	}

	@Override
	public String getSessionId() {
		return Integer.toHexString(session.hashCode());
	}

	@Override
	public Object getSessionMutex() {
		return null;
	}

	@Override
	protected void updateAccessedSessionAttributes() {
	}

}
