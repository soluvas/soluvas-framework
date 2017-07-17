package org.soluvas.mongo;

import java.util.List;
import java.util.Set;

import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.commons.PersonInfo2;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.person.PersonCustomerRoleHistoryRepository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * @author atang
 *
 */
public class MongoPersonCustomerRoleHistoryRepository extends MongoRepositoryBase<PersonCustomerRoleHistory> implements
		PersonCustomerRoleHistoryRepository {

	public MongoPersonCustomerRoleHistoryRepository(String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(PersonCustomerRoleHistory.class, PersonCustomerRoleHistory.class, 1l, mongoUri, 
				ReadPattern.DUAL, "personCustomerRoleHistory", migrationEnabled, autoExplainSlow);
		upgradeEntityFrom1To2();
	}
	
	private void upgradeEntityFrom1To2() {
		final DBObject query = new BasicDBObject();
		query.put("personInfo.className", "org.soluvas.commons.impl.PersonInfoImpl");
		
		final DBCursor cursor = primary.find(query);
		log.debug("Updating for {} row(s)", cursor.size());
		for (final DBObject dbObject : cursor) {
			dbObject.put("personInfo.className", PersonInfo2.class.getName());
			primary.save(dbObject);
		}//end of looping
	}

	
	@Override
	public void addNewHistory(PersonCustomerRoleHistory newHistory) {
		add(newHistory);
	}
	
	@Override
	public List<PersonCustomerRoleHistory> findByToCustomerRoleId(Set<String> toCustomerRoleIds) {
		BasicDBObject query = new BasicDBObject();
		query.put("toCustomerRole", new BasicDBObject("$in", toCustomerRoleIds));
		
		Page<PersonCustomerRoleHistory> page = findAllByQuery(query, new PageOffsetRequest(0, 100));
		
		return page.getContent();
	}
}
