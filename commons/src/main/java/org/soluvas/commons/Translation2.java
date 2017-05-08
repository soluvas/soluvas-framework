/**
 */
package org.soluvas.commons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.TranslationImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.TranslationImpl#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @generated NOT
 */
public class Translation2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected static final String LANGUAGE_EDEFAULT = null;

	protected String language = LANGUAGE_EDEFAULT;

	protected Map<String, String> messages;

	public Translation2() {
		super();
	}
	
	public Translation2(String language, Map<String, String> messages) {
		super();
		this.language = language;
		getMessages().putAll(messages);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String newLanguage) {
		language = newLanguage;
	}

	public Map<String, String> getMessages() {
		if (messages == null) {
			messages = new HashMap<>();
		}
		return messages;
	}
	
	protected void setMessages(Map<String, String> messages) {
		getMessages().clear();
		getMessages().putAll(messages);
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}
	
	public void copyFrom(org.soluvas.commons.Translation2 upTranslation) {
		setLanguage(upTranslation.getLanguage());
		getMessages().putAll(upTranslation.getMessages());
	}

} //Translation2
