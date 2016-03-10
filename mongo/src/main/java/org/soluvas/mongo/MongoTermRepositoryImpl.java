package org.soluvas.mongo;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.soluvas.data.DataException;
import org.soluvas.data.Existence;
import org.soluvas.data.Term2;
import org.soluvas.data.Term2Catalog;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.json.JsonUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.ReadPreference;

/**
 * @author rudi
 *
 */
public class MongoTermRepositoryImpl extends MongoRepositoryBase<Term2> implements MongoTermRepository {
	
	private final CacheManager cacheMgr;
	private final String tenantId;
	
	public MongoTermRepositoryImpl(String mongoUri, boolean migrationEnabled, boolean autoExplainSlow,
			final CacheManager cacheMgr, final String tenantId) {
		super(Term2.class, Term2.class, Term2.CURRENT_SCHEMA_VERSION, mongoUri, ReadPattern.DUAL,
				"term", migrationEnabled, autoExplainSlow,
				Index.uniqueAsc("formalId"),
				Index.asc("name"),
				Index.asc("enumerationId")
				);
		
		this.cacheMgr = cacheMgr;
		this.tenantId = tenantId;
		
		addBaseTerms();
	}
	
	public void addBaseTerms() {
		if (count() <= 0) {
			try {
				final URL url = Term2.class.getResource("soluvas.TermDataCatalog.jsonld");
				final Term2Catalog dataCatalog = JsonUtils.mapper.readValue(url, Term2Catalog.class);
				for (final Term2 term2 : dataCatalog.getData()) {
					add(term2);
				}
			} catch (IOException e) {
				throw new DataException("Failed to addBaseTerms: " + e);
			}
		}
	}
	
	@Override
	public Page<Term2> findAllByEnumId(String enumerationId, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("enumerationId", enumerationId);
		
		return findAllByQuery(query, pageable);
	}

	@Override
	public long countByEnumId(String enumerationId) {
		final BasicDBObject query = new BasicDBObject();
		query.put("enumerationId", enumerationId);
		
		return countByQuery(ReadPreference.secondaryPreferred(), query, "countByEnumId", enumerationId);
	}

	@Override
	public Existence<String> existsByEnumerationId(String enumerationId,
			String termId) {
		return exists(enumerationId + "/" + termId) ? Existence.of(termId, termId) : Existence.absent();
	}

	@Override
	public Term2 findOneByFormalId(String formalId) {
		final BasicDBObject query = new BasicDBObject("formalId", formalId);
		return findOnePrimaryAsEntity(query, null, "findOneByFormalId", formalId);
	}

	@Override
	public Page<Term2> findAll(String enumerationId, String searchText, Pageable pageable) {
		final String quotedSearchText = Pattern.quote(searchText);
		final Pattern pattern = Pattern.compile(".*" + quotedSearchText + ".*", Pattern.CASE_INSENSITIVE);
		final BasicDBObject query = new BasicDBObject();
		query.put("enumerationId", enumerationId);
		query.put("name", pattern);
		
		return findAllByQuery(query, pageable);
	}
	
	@Override
	public Page<Term2> findAll(String enumerationId, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("enumerationId", enumerationId);
		
		return findAllByQuery(query, pageable);
	}
	
	@Override
	public Page<Term2> findAllByExCacheable(String enumerationId, Pageable pageable) {
		final Cache term2EnumIdCache = cacheMgr.getCache("term2EnumId");
		final String key = String.format("term2:%s:%s", tenantId, enumerationId);
		@Nullable List<Term2> term2List = term2EnumIdCache.get(key, List.class);
		log.debug("findAllByExCacheable {}: {}", key, term2List != null ? term2List.size() : null);
		if (term2List == null) {
			term2List = findAll(enumerationId, pageable).getContent();
			if (term2List != null) {
				log.debug("Put {} for new term2 to the cache", key);
				term2EnumIdCache.put(key, term2List);
			}
		}

		return new PageImpl<>(term2List, pageable, term2List.size());
	}

	@Override
	public Page<Term2> findAll(Collection<String> ids, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", new BasicDBObject("$in", ids));
		final Page<Term2> page = findAllByQuery(query, pageable);
		return page;
	}
	
	@Override
	public Page<Term2> findAllByEnumIds(List<String> enumerationIds, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("enumerationId", new BasicDBObject("$in", enumerationIds));
		
		return findAllByQuery(query, pageable);
	}
	
	@Override
	@Nullable public Term2 existsByEx(String id) {
		final BasicDBObject query = new BasicDBObject("_id", id);
		final DBObject objTerm2 = primary.findOne(query);
		log.trace("existsByEx for id '{}'", id);
		if (objTerm2 != null) {
			final String actualId = (String) objTerm2.get("_id");
			log.trace("Got term2 for id '{}'", actualId);
			return new DBObjectToEntity().apply(objTerm2);
		} else {
			return null;
		}
	}

	@Override
	@Nullable public Term2 findOneByExCacheable(String id) {
		final Cache term2idsCache = cacheMgr.getCache("term2ids");
		final String key = String.format("term2:%s:%s", tenantId, id);
		@Nullable Term2 term2 = term2idsCache.get(key, Term2.class);
		log.trace("findOneByExCacheable {}: {}", key, term2 != null ? term2.getId() : null);
		if (term2 == null) {
			term2 = existsByEx(id);
			if (term2 != null) {
				log.trace("Put {} for new term2 to the cache", key);
				term2idsCache.put(key, term2);
			}
		}
		return term2;
	}
	
}

