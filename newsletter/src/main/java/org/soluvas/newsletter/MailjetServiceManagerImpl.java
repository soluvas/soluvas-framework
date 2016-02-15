package org.soluvas.newsletter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public class MailjetServiceManagerImpl implements MailjetServiceManager {
	private final MailjetCredential credential;
	private final Boolean isServiceEnable;
	
	private final ObjectMapper mapper = JsonUtils.mapper;
	private final String baseApiUri = "https://api.mailjet.com/v3/REST/";
	private final List<BasicHeader> basicHeaders = new ArrayList<BasicHeader>();
	
	public MailjetServiceManagerImpl(MailjetCredential credential, Boolean isServiceEnable) {
		super();
		this.credential = credential;
		this.isServiceEnable = isServiceEnable;
		
		if (isServiceEnable != null && isServiceEnable) {
			Preconditions.checkArgument(!Strings.isNullOrEmpty(credential.getApiKey()), "If Mailjet is enabled, apiKey must be provided");
			Preconditions.checkArgument(!Strings.isNullOrEmpty(credential.getSecretKey()), "If Mailjet is enabled, secretKey must be provided");
		}
		
		basicHeaders.add(new BasicHeader("Accept", "application/json"));
		basicHeaders.add(new BasicHeader("user-agent", "mailjet-apiv3-java/v3.0.0"));
//		basicHeaders.add(new BasicHeader("Content-Type", "application/json"));
		
		final String authEncBytes = Base64.encodeBase64String((credential.getApiKey() + ":" + credential.getSecretKey()).getBytes());
		basicHeaders.add(new BasicHeader("Authorization", "Basic "+ authEncBytes));
	}
	
	@Override
	public AddListContactsResponse addContact(String email) throws IOException {
		final CloseableHttpClient httpClient = HttpClients.custom().build();
		try {
			final List<NameValuePair> data = new ArrayList<NameValuePair>();
			data.add(new BasicNameValuePair("Email", email));
			data.add(new BasicNameValuePair("Action", "unsub"));
			data.add(new BasicNameValuePair("Content-Type", "application/json"));
			
			final String requestUri = baseApiUri + "contactslist/"+ credential.getDefaultContactID() +"/managecontact";
			final HttpPost httpPost = new HttpPost(requestUri);
			httpPost.setEntity(new UrlEncodedFormEntity(data, "UTF-8"));
			httpPost.setHeaders(basicHeaders.toArray(new BasicHeader[basicHeaders.size()]));
			
			
			CloseableHttpResponse reqResponse = httpClient.execute(httpPost);
			final String responseContent = IOUtils.toString(reqResponse.getEntity().getContent());
			
			
			return mapper.readValue(responseContent, AddListContactsResponse.class);
		} finally {
			httpClient.close();
		}
	}
	
	
}
