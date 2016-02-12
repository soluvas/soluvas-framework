/**
 * 
 */
package org.soluvas.newsletter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
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
public class Mailjet implements Serializable {
	private static final Logger log = LoggerFactory.getLogger(Mailjet.class);
	private String basicApiUri;
	
	private UsernamePasswordCredentials userCredentials;
	private DefaultHttpClient httpClient;
	
	private final ObjectMapper mapper = JsonUtils.mapper;
	
	private String errorMessage;
	private AddContactResponse addContactRespone;
	private MailjetManager mailjetMgr;
	
	public Mailjet(MailjetManager mailjetManager) {
		userCredentials = new UsernamePasswordCredentials(mailjetManager.getApiKey(),
				mailjetManager.getSecretKey()
				);
		
		this.basicApiUri = "https://api.mailjet.com/v3/REST/";
		httpClient = new DefaultHttpClient();
		
		httpClient.getCredentialsProvider().setCredentials(
				AuthScope.ANY
				, userCredentials);
		mailjetMgr = mailjetManager;
	}
	
	public Mailjet() {
		super();
	}
	
	/**
	 * 
	 * @param contactID
	 * @param emailValue
	 * @return
	 */
	@Deprecated
	public AddContactResponse addContact(long contactID, String emailValue) {
		ArrayList<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("Email", emailValue));
		formParams.add(new BasicNameValuePair("Action", "addforce"));
		
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
			HttpPost httpPost = new HttpPost(basicApiUri + "contactlist/"+ contactID +"/managecontact");
			
			final List<BasicHeader> basicHeaders = new ArrayList<BasicHeader>();
			basicHeaders.add(new BasicHeader("Accept", "application/json"));
			basicHeaders.add(new BasicHeader("user-agent", "mailjet-apiv3-java/v3.0.0"));
			
			org.apache.commons.codec.binary.Base64.encodeBase64((mailjetMgr.getApiKey() + ":" + mailjetMgr.getSecretKey()).getBytes());
			basicHeaders.add(new BasicHeader("Authorization", "Basic "));
			
			httpPost.setHeader("Accept", "application/json");
			
			
			
			httpPost.setEntity(entity);
			
			log.info("sending request to add contact {}", emailValue);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);
			log.debug("HttpResponse status code {}", httpResponse.getStatusLine().getStatusCode());
			if (httpResponse.getStatusLine().getStatusCode() != 200 ){
				throw new IOException(String.format("throw Http Error %s", 
						httpResponse.getStatusLine().getReasonPhrase()));
			}
			final String responseContent = IOUtils.toString(httpResponse.getEntity().getContent());
			return mapper.readValue(responseContent, AddContactResponse.class);
			
		} catch (Exception ex) {
			throw new RuntimeException("Cannot add contact "+ emailValue, ex);
		}
	}
	
	/**
	 * 
	 * @param listId
	 * @param emailValue
	 * @return
	 */
	public boolean insertContact(long contactID, String emailValue) {
		try {
			final String apiUri = basicApiUri + "contactslist/"+ contactID +"/managecontact";
			HttpPost httpPost = new HttpPost(apiUri);
			
			final List<BasicHeader> basicHeaders = new ArrayList<BasicHeader>();
			basicHeaders.add(new BasicHeader("Accept", "application/json"));
			basicHeaders.add(new BasicHeader("user-agent", "mailjet-apiv3-java/v3.0.0"));
			
			final String authEncBytes = Base64.encodeBase64String((mailjetMgr.getApiKey() + ":" + mailjetMgr.getSecretKey()).getBytes());
			basicHeaders.add(new BasicHeader("Authorization", "Basic "+ authEncBytes));
			httpPost.setHeaders(basicHeaders.toArray(new BasicHeader[basicHeaders.size()]));
			
			ArrayList<NameValuePair> formParams = new ArrayList<NameValuePair>();
			formParams.add(new BasicNameValuePair("Email", emailValue));
			formParams.add(new BasicNameValuePair("Action", "unsub"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
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
			throw new RuntimeException("Cannot add contact "+ emailValue, ex);
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
		HttpGet httpGet = new HttpGet(basicApiUri + "contactList/?output=json");
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
	public AddListContactsResponse createListContact(String label, String name) {
		ArrayList<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("label", label));
		formParams.add(new BasicNameValuePair("name", name));
		
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
			HttpPost httpPost = new HttpPost(basicApiUri + "listsAddcontact/?output=json");
			httpPost.setEntity(entity);
			
			log.info("sending request to create new list contact");
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() != 200 )
				throw new IOException(String.format("throw Http Error %s", 
						httpResponse.getStatusLine().getReasonPhrase())
						);
			
			final String responseContent = IOUtils.toString(httpResponse.getEntity().getContent());
			return mapper.readValue(responseContent, AddListContactsResponse.class);
			
		} catch (Exception ex) {
			throw new RuntimeException("Error when create new list contact ", ex);
		}
	}
	
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
