/**
 * 
 */
package org.soluvas.newsletter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
@Deprecated
public class Mailjet implements Serializable {
	private static final Logger log = LoggerFactory.getLogger(Mailjet.class);
	private String apiUri;
	
	private UsernamePasswordCredentials userCredentials;
	private DefaultHttpClient httpClient;
	
	private final ObjectMapper mapper = JsonUtils.mapper;
	
	private String errorMessage;
	private AddContactResponse addContactRespone;
	
	public Mailjet(MailjetManager mailjetManager) {
		userCredentials = new UsernamePasswordCredentials(mailjetManager.getApiKey(),
				mailjetManager.getSecretKey()
				);
		this.apiUri = "https://api.mailjet.com/0.1/";
		httpClient = new DefaultHttpClient();
		httpClient.getCredentialsProvider().setCredentials(
				AuthScope.ANY
				, userCredentials);
	}
	
	public Mailjet() {
		super();
	}
	
	/**
	 * 
	 * @param listId
	 * @param email
	 * @return
	 */
	@Deprecated
	public AddContactResponse addContact(long listId, String email) {
		ArrayList<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("contact", email));
		formParams.add(new BasicNameValuePair("id", String.valueOf(listId)));
		
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
			HttpPost httpPost = new HttpPost(apiUri + "listsAddcontact/?output=json");
			httpPost.setEntity(entity);
			
			log.info("sending request to add contact");
			HttpResponse httpResponse = httpClient.execute(httpPost);
			log.debug("HttpResponse status code {}", httpResponse.getStatusLine().getStatusCode());
			if (httpResponse.getStatusLine().getStatusCode() != 200 ){
				throw new IOException(String.format("throw Http Error %s", 
						httpResponse.getStatusLine().getReasonPhrase()));
			}
			final String responseContent = IOUtils.toString(httpResponse.getEntity().getContent());
			return mapper.readValue(responseContent, AddContactResponse.class);
			
		} catch (Exception ex) {
			throw new RuntimeException("Cannot add contact "+ email, ex);
		}
	}
	
	/**
	 * 
	 * @param listId
	 * @param email
	 * @return
	 */
	public boolean insertContact(long listId, String email) {
		ArrayList<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("contact", email));
		formParams.add(new BasicNameValuePair("id", String.valueOf(listId)));
		
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
			HttpPost httpPost = new HttpPost(apiUri + "listsAddcontact/?output=json");
			httpPost.setEntity(entity);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			log.info("HttpResponse status code {}", httpResponse.getStatusLine().getStatusCode());
			
			if (httpResponse.getStatusLine().getStatusCode() != 200 ){
				final int statusCode = httpResponse.getStatusLine().getStatusCode();
				final String messageDesc = getMessageDescription(statusCode);
				setErrorMessage(messageDesc);
				return false;
			} else {
				final String responseContent = IOUtils.toString(httpResponse.getEntity().getContent());
				final AddContactResponse addedContact = mapper.readValue(responseContent, AddContactResponse.class);
				setAddContactRespone(addedContact);
				return true;
			}
			
		} catch (Exception ex) {
			throw new RuntimeException("Cannot add contact "+ email, ex);
		}
	}

	
	/**
	 * add contact to certain contact's id
	 * @param id
	 * @param emails
	 * @return
	 */
	public AddContactResponse addContacts(String id, List<String> emails) {
		return null;
	}
	
	/**
	 * show all contacts
	 * @return
	 */
	public ListContactsResponse showContacts() {
		HttpGet httpGet = new HttpGet(apiUri + "contactList/?output=json");
		try {
			log.info("sending request to mailjet to show all contacts");
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() != 200 )
				throw new IOException(String.format("throw Http Error %s", 
						httpResponse.getStatusLine().getReasonPhrase())
						);
			final String responseContent = IOUtils.toString(httpResponse.getEntity().getContent());
			return mapper.readValue(responseContent, ListContactsResponse.class);
			
		} catch (Exception ex) {
			throw new RuntimeException("Error when building request to mailjet ", ex);
		} 
	}
	
	/**
	 * create new list contacts
	 * @param label
	 * @param name
	 * @return
	 */
//	public AddListContactsResponse createListContact(String label, String name) {
//		ArrayList<NameValuePair> formParams = new ArrayList<NameValuePair>();
//		formParams.add(new BasicNameValuePair("label", label));
//		formParams.add(new BasicNameValuePair("name", name));
//		
//		try {
//			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
//			HttpPost httpPost = new HttpPost(apiUri + "listsAddcontact/?output=json");
//			httpPost.setEntity(entity);
//			
//			log.info("sending request to create new list contact");
//			HttpResponse httpResponse = httpClient.execute(httpPost);
//			if (httpResponse.getStatusLine().getStatusCode() != 200 )
//				throw new IOException(String.format("throw Http Error %s", 
//						httpResponse.getStatusLine().getReasonPhrase())
//						);
//			
//			final String responseContent = IOUtils.toString(httpResponse.getEntity().getContent());
//			return mapper.readValue(responseContent, AddListContactsResponse.class);
//			
//		} catch (Exception ex) {
//			throw new RuntimeException("Error when create new list contact ", ex);
//		}
//	}
	
	/**
	 * 
	 * @param statusCode
	 * @return
	 */
	private String getMessageDescription(int statusCode) {
		switch (statusCode) {
		case 500 :
			return "Unknown error occurs";
		case 200 : 
			return "All gone well. Congrats";
		case 201 : 
			return "A new insertion was done";
		case 204 :
			return "No content found or expected to return";
		case 304 :
			return "Nothing was modified";
		case 400 :
			return "One or more arguments are missing or maybe mispelling";
		case 401 :
			return "You have specified an incorrect Apikey or username/password couple";
		case 404 :
			return "The method you are trying to reach don't exists ";
		case 405 :
			return "Method not allowed";
		default :
				return "Unknown status code";
			
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the addContactRespone
	 */
	public AddContactResponse getAddContactRespone() {
		return addContactRespone;
	}

	/**
	 * @param addContactRespone the addContactRespone to set
	 */
	public void setAddContactRespone(AddContactResponse addContactRespone) {
		this.addContactRespone = addContactRespone;
	}

	
}
