package org.soluvas.mongo;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.soluvas.data.DataException;
import org.soluvas.data.Existence;
import org.soluvas.data.Term2;
import org.soluvas.data.Term2Catalog;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.json.JsonUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.ReadPreference;

/**
 * @author rudi
 *
 */
public class MongoTermRepositoryImpl extends MongoRepositoryBase<Term2> implements MongoTermRepository {
	
	public MongoTermRepositoryImpl(String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(Term2.class, Term2.class, Term2.CURRENT_SCHEMA_VERSION, mongoUri, ReadPattern.DUAL,
				"term", migrationEnabled, autoExplainSlow,
				Index.uniqueAsc("formalId"),
				Index.asc("name"),
				Index.asc("enumerationId")
				);
		
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
	
}

