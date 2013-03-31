package org.soluvas.facebook;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Network;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;

/**
 * Download list of friends.
 * @author ceefour
 */
@Service @Lazy
public class FriendListDownloader {

	private static final Logger log = LoggerFactory.getLogger(FriendListDownloader.class);
	private HttpClient httpClient;
	private ExecutorService executor;
	
//	public FriendListDownloader() {
//	}
	
	@Inject
	public FriendListDownloader(HttpClient httpClient, @Network ExecutorService executor) {
		super();
		this.httpClient = httpClient;
		this.executor = executor;
	}

	/**
	 * Fetch a page of friend list as JSON Node. Paging metadata is returned, but not processed.
	 * 
	 * @param uri Example: https://graph.facebook.com/me/friends
	 * @return JSON Node containing first page of friend list.
	 */
	public Future<JsonNode> fetchFriendsPage(final URI uri) {
		return executor.submit(new Callable<JsonNode>() {
			@Override
			public JsonNode call() throws Exception {
				log.info("Fetching friends page {}", uri);
				HttpGet getReq = new HttpGet(uri);
				HttpResponse friendsResp = httpClient.execute(getReq);
				
				ObjectMapper mapper = new ObjectMapper();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				JsonNode json = mapper.readTree(friendsResp.getEntity().getContent());
				return json;
			}
		});
	}
	
	/**
	 * Fetch the first page then subsequent pagees of friend list as list of JSON Nodes.
	 * @param uri Example: https://graph.facebook.com/me/friends
	 * @return List of JSON Nodes (one {@link JsonNode} per page), containing friend list.
	 */
	public Future<List<JsonNode>> fetchFriendsPages(final URI uri) {
		return executor.submit(new Callable<List<JsonNode>>() {
			@Override
			public List<JsonNode> call() throws Exception {
				ArrayList<JsonNode> pages = Lists.newArrayList();
				URI currentUri = uri;
				ObjectMapper mapper = new ObjectMapper();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				while (currentUri != null) {
					Future<JsonNode> page = fetchFriendsPage(currentUri);
					currentUri = null;
					
					JsonNode json = page.get();
					pages.add(json);
					
//					mapper.writeValue(System.out, json);
					
					if (json.has("paging")) {
						JsonNode pagingNode = json.get("paging");
						if (pagingNode.has("next")) {
							currentUri = URI.create(pagingNode.get("next").asText());
						}
					}
					
					if (currentUri == null) {
						log.info("It was the last page.");
					}
				}
				return pages;
			}
		});
	}
	
}
