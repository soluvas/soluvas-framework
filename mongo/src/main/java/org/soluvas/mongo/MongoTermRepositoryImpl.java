package org.soluvas.mongo;

import java.util.regex.Pattern;

import org.soluvas.data.Existence;
import org.soluvas.data.Term2;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;

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
		
		return countByQuery(ReadPreference.secondaryPreferred(), query, "count", enumerationId);
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
	
}

