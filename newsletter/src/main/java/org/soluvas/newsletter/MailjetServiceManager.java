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

	AddListContactsResponse addContact(String email) throws IOException;

}
