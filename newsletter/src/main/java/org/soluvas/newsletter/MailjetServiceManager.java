/**
 * 
 */
package org.soluvas.newsletter;

import java.io.IOException;

/**
 * @author atang
 *
 */
public interface MailjetServiceManager {
	public enum AddContactActionType {
		ADDFORCE, 
		ADDNOFORCE, 
		UNSUB
	}
	MailjetResponse addContact(String email) throws IOException;

}
