package org.soluvas.facebook;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorSystem;
import akka.dispatch.Future;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.japi.Function;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 *
 */
public class UserListParser {
	
	private transient Logger log = LoggerFactory.getLogger(UserListParser.class);
	@Inject private ActorSystem actorSystem;
	private ObjectMapper mapper = new ObjectMapper();
	
	public UserListParser() {
	}
	
	public UserListParser(ActorSystem actorSystem) {
		super();
		this.actorSystem = actorSystem;
	}

	/**
	 * Parse a list of JSON users.
	 * @param rootNode should contain a 'data' property, which contains an array of objects containing id and name.
	 */
	public Future<List<UserRef>> parse(final JsonNode rootNode) {
		return Futures.future(new Callable<List<UserRef>>() {
			@Override
			public List<UserRef> call() throws Exception {
				List<UserRef> userList = mapper.convertValue(rootNode.get("data"), new TypeReference<List<UserRef>>() { });
				log.debug("Parsed list of {} Facebook users", userList.size());
				return userList;
			}
		}, actorSystem.dispatcher());
	}

	public Future<List<UserRef>> parse(final File file) {
		return Futures.future(new Callable<JsonNode>() {
			@Override
			public JsonNode call() throws Exception {
				JsonNode jsonNode = mapper.readTree(file);
				return jsonNode;
			}
		}, actorSystem.dispatcher()).flatMap(new Mapper<JsonNode, Future<List<UserRef>>>() {
			@Override
			public Future<List<UserRef>> apply(JsonNode jsonNode) {
				return parse(jsonNode);
			}
		});
	}
	
	public Future<List<UserRef>> parse(final List<File> files) {
		// Parse user list from JSON files 
		log.info("Parsing user list from {} files: {}", files.size(), files);
		return Futures.traverse(files, new Function<File, Future<List<UserRef>>>() {
			@Override
			public Future<List<UserRef>> apply(File file) {
				log.info("Parsing user list from {}", file);
				return parse(file);
			}
		}, actorSystem.dispatcher()).map(new Mapper<Iterable<List<UserRef>>, List<UserRef>>() {
			@Override
			public List<UserRef> apply(Iterable<List<UserRef>> multiUserList) {
				List<UserRef> userList = Lists.newArrayList(Iterables.concat(multiUserList));
				log.info("Parsed {} users", userList.size());
				return userList;
			}
		});
	}
	
	public Future<List<UserRef>> parseNodes(final List<JsonNode> nodes) {
		// Parse user list from JSON files 
		log.info("Parsing user list from {} JSON nodes: {}", nodes.size());
		Future<List<UserRef>> usersFuture = Futures.traverse(nodes, new Function<JsonNode, Future<List<UserRef>>>() {
			@Override
			public Future<List<UserRef>> apply(JsonNode jsonNode) {
				return parse(jsonNode);
			}
		}, actorSystem.dispatcher()).map(new Mapper<Iterable<List<UserRef>>, List<UserRef>>() {
			@Override
			public List<UserRef> apply(Iterable<List<UserRef>> multiUserList) {
				List<UserRef> userList = Lists.newArrayList(Iterables.concat(multiUserList));
				log.info("Parsed {} users", userList.size());
				return userList;
			}
		});
		return usersFuture;
	}

	public Future<List<UserRef>> parseNames(final List<String> fileNames) {
		List<File> files = Lists.transform(fileNames, new com.google.common.base.Function<String, File>() {
			@Override
			public File apply(String input) {
				return new File(input);
			}
		});
		return parse(files);
	}
	
}
