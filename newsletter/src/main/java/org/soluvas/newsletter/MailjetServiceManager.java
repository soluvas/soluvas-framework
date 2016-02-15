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

	MailjetResponse addContact(String email) throws IOException;

}
