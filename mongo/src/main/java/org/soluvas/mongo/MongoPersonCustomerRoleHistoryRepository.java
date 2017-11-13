package org.soluvas.mongo;

import java.util.List;
import java.util.Set;

import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.commons.PersonInfo2;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
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
			if (dbObject.containsField("personInfo")) {
				final DBObject objPersonInfo = (DBObject) dbObject.get("personInfo");
				objPersonInfo.put("className", PersonInfo2.class.getName());
			}
			primary.save(dbObject);
		}//end of looping
	}
	
	@Override
	public List<PersonCustomerRoleHistory> findByToCustomerRoleId(Set<String> toCustomerRoleIds) {
		BasicDBObject query = new BasicDBObject();
		query.put("customerRole", new BasicDBObject("$in", toCustomerRoleIds));
		
		Page<PersonCustomerRoleHistory> page = findAllByQuery(query, new PageOffsetRequest(0, 100));
		
		return page.getContent();
	}

	@Override
	public List<PersonCustomerRoleHistory> findByPersonInfoId(String id) {
		BasicDBObject query = new BasicDBObject();
		query.put("personInfo.id", id);
			
		Sort sort = new Sort(Direction.DESC, "modificationTime");
	    return findAllByQuery(query, new PageRequest(0, 100, sort)).getContent();
	}
}
