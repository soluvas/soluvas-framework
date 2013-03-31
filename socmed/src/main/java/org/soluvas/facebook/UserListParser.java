package org.soluvas.facebook;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Cpu;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 *
 */
@Service @Lazy
public class UserListParser {
	
	private static final Logger log = LoggerFactory.getLogger(UserListParser.class);
	private ExecutorService executor;
	private ObjectMapper mapper = new ObjectMapper();
	
//	public UserListParser() {
//	}
	
	@Inject
	public UserListParser(@Cpu ExecutorService executor) {
		super();
		this.executor = executor;
	}

	/**
	 * Parse a list of JSON users.
	 * @param rootNode should contain a 'data' property, which contains an array of objects containing id and name.
	 */
	public Future<List<UserRef>> parse(final JsonNode rootNode) {
		return executor.submit(new Callable<List<UserRef>>() {
			@Override
			public List<UserRef> call() throws Exception {
				List<UserRef> userList = mapper.convertValue(rootNode.get("data"), new TypeReference<List<UserRef>>() { });
				log.debug("Parsed list of {} Facebook users", userList.size());
				return userList;
			}
		});
	}

	public Future<List<UserRef>> parse(final File file) {
		Future<JsonNode> userListJsonFuture = executor.submit(new Callable<JsonNode>() {
			@Override
			public JsonNode call() throws Exception {
				JsonNode jsonNode = mapper.readTree(file);
				return jsonNode;
			}
		});
		JsonNode userListJson;
		try {
			userListJson = userListJsonFuture.get();
		} catch (Exception e) {
			log.error("Cannot parse " + file, e);
			throw new RuntimeException("Cannot parse " + file, e);
		}
		
		Future<List<UserRef>> userListFuture = parse(userListJson);
		return userListFuture;
	
//		Future.future { mapper.readTree(_) }.flatMap { parse(_) }
//		
//		return Futures.future(new Callable<JsonNode>() {
//			@Override
//			public JsonNode call() throws Exception {
//				JsonNode jsonNode = mapper.readTree(file);
//				return jsonNode;
//			}
//		}).flatMap(new Mapper<JsonNode, Future<List<UserRef>>>() {
//			@Override
//			public Future<List<UserRef>> apply(JsonNode jsonNode) {
//				return parse(jsonNode);
//			}
//		});
	}
	
	public Future<List<UserRef>> parse(final List<File> files) {
		// Parse user list from JSON files 
		log.info("Parsing user list from {} files: {}", files.size(), files);
		
		List<Future<List<UserRef>>> userListFutures = Lists.transform(files, new Function<File, Future<List<UserRef>>>() {
			@Override
			@Nullable
			public Future<List<UserRef>> apply(@Nullable File input) {
				log.info("Parsing user list from {}", input);
				return parse(input);
			}
		});
		List<List<UserRef>> userLists = Lists.transform(userListFutures, new Function<Future<List<UserRef>>, List<UserRef>>() {
			@Override
			@Nullable
			public List<UserRef> apply(@Nullable Future<List<UserRef>> input) {
				try {
					return input.get();
				} catch (Exception e) {
					log.error("Cannot get Future " + input, e);
					return ImmutableList.of();
				}
			}
		});
		final Iterable<UserRef> concatUsers = Iterables.concat(userLists);
		Future<List<UserRef>> concatUsersFuture = executor.submit(new Callable<List<UserRef>>() {
			@Override
			public List<UserRef> call() throws Exception {
				return ImmutableList.copyOf(concatUsers);
			}
		});
		return concatUsersFuture;
		
//		return Futures.traverse(files, new Function<File, Future<List<UserRef>>>() {
//			@Override
//			public Future<List<UserRef>> apply(File file) {
//				log.info("Parsing user list from {}", file);
//				return parse(file);
//			}
//		}, actorSystem.dispatcher()).map(new Mapper<Iterable<List<UserRef>>, List<UserRef>>() {
//			@Override
//			public List<UserRef> apply(Iterable<List<UserRef>> multiUserList) {
//				List<UserRef> userList = Lists.newArrayList(Iterables.concat(multiUserList));
//				log.info("Parsed {} users", userList.size());
//				return userList;
//			}
//		});
	}
	
	public Future<List<UserRef>> parseNodes(final List<JsonNode> nodes) {
		// Parse user list from JSON files 
		log.info("Parsing user list from {} JSON nodes: {}", nodes.size());
		
		List<Future<List<UserRef>>> userListFutures = Lists.transform(nodes, new Function<JsonNode, Future<List<UserRef>>>() {
			@Override
			@Nullable
			public Future<List<UserRef>> apply(@Nullable JsonNode input) {
				return parse(input);
			}
		});
		List<List<UserRef>> userLists = Lists.transform(userListFutures, new Function<Future<List<UserRef>>, List<UserRef>>() {
			@Override
			@Nullable
			public List<UserRef> apply(@Nullable Future<List<UserRef>> input) {
				try {
					return input.get();
				} catch (Exception e) {
					log.error("Cannot get Future " + input, e);
					return ImmutableList.of();
				}
			}
		});
		final Iterable<UserRef> concatUsers = Iterables.concat(userLists);
		Future<List<UserRef>> concatUsersFuture = executor.submit(new Callable<List<UserRef>>() {
			@Override
			public List<UserRef> call() throws Exception {
				return ImmutableList.copyOf(concatUsers);
			}
		});
		return concatUsersFuture;
		
//		Future<List<UserRef>> usersFuture = Futures.traverse(nodes, new Function<JsonNode, Future<List<UserRef>>>() {
//			@Override
//			public Future<List<UserRef>> apply(JsonNode jsonNode) {
//				return parse(jsonNode);
//			}
//		}, actorSystem.dispatcher()).map(new Mapper<Iterable<List<UserRef>>, List<UserRef>>() {
//			@Override
//			public List<UserRef> apply(Iterable<List<UserRef>> multiUserList) {
//				List<UserRef> userList = Lists.newArrayList(Iterables.concat(multiUserList));
//				log.info("Parsed {} users", userList.size());
//				return userList;
//			}
//		});
//		return usersFuture;
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
