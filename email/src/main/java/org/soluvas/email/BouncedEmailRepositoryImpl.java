package org.soluvas.email;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.mongo.Index;
import org.soluvas.mongo.MongoRepositoryBase;

import com.mongodb.BasicDBObject;

/**
 * @author eki
 *
 */
public class BouncedEmailRepositoryImpl extends MongoRepositoryBase<BouncedEmail> implements BouncedEmailRepository {
	
	private static final Logger log = LoggerFactory.getLogger(BouncedEmailRepositoryImpl.class);

	public BouncedEmailRepositoryImpl(final String mongoUri, final boolean migrationEnabled, final boolean autoExplainSlow) {
		super(BouncedEmail.class, BouncedEmail.class, BouncedEmail.schemaVersion, mongoUri,
				MongoRepositoryBase.ReadPattern.SECONDARY_PREFERRED, "bouncedEmail", migrationEnabled, autoExplainSlow,
				Index.asc("email"));
		
		log.debug("'{}' has been created..", BouncedEmailRepository.class.getName());
	}

	@Override
	public Map<String, Boolean> existsByEmails(Collection<String> emailList){
		final Map<String, Boolean> bouncedEmailMap = new HashMap<>();
		emailList.stream().forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				final BasicDBObject query = new BasicDBObject("email", t);
				final boolean exists = countByQuery(query) > 0;
				bouncedEmailMap.put(t, exists);
			}
		});
		log.debug("Bounced for email: {}", bouncedEmailMap.entrySet());
		return bouncedEmailMap;
	}
	
	
	@Override
	public boolean existByEmail(String email){
		final BasicDBObject query = new BasicDBObject("email", email);
		boolean exists = countByQuery(query) > 0;
		return exists;
	}
	
	@Override
	public BouncedEmail findByEmail(String email){
		final BasicDBObject query = new BasicDBObject("email", email);
		return findOneByQuery(query);
	}

}
