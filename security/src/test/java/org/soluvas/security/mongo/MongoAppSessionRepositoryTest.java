package org.soluvas.security.mongo;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.soluvas.security.AppSession;
import org.soluvas.security.AppSessionStatus;
import org.soluvas.security.SecurityFactory;
import org.soluvas.security.impl.AppSessionImpl;
import org.soluvas.security.impl.MongoAppSessionRepository;

import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.logging.slf4j.SLF4JLogrImplFactory;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

/**
 * @author rully
 *
 */
public class MongoAppSessionRepositoryTest {

	private MongoAppSessionRepository appSessionRepo;
	
	static {
		MorphiaLoggerFactory.registerLogger(SLF4JLogrImplFactory.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		appSessionRepo = new MongoAppSessionRepository("mongodb://localhost/berbatik_dev");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void save() {
		final AppSession appSession = SecurityFactory.eINSTANCE.createAppSession();
		appSession.setId("00000000");
		appSession.setCreationTime(new DateTime());
		appSession.setStatus(AppSessionStatus.ACTIVE);
		appSession.setIpAddress("127.0.0.1");
		appSession.setTimeout(1800000L);
		appSession.setAccessTime(new DateTime());
		appSession.setExpiryTime(new DateTime());
		final Object attr1 = new Object();
//		final SessionBindingListener attr1 = new HttpSessionStore.SessionBindingListener();
		appSession.getAttributes().put("Wicket:SessionUnbindingListener-berbatik_dev", attr1);
		final AppSession added = appSessionRepo.add(appSession);
		assertNotNull(appSession);
//		new AppSession.FromSession().apply(session);
//		className" : "org.apache.wicket.session.HttpSessionStore$SessionBindingListener" , "applicationKey" : "berbatik_dev" , "sessionId" : "db7e84a6-9bbf-44cb-9070-92aefe00d48a"}}}		
	}

	@Test
	public void find() {
		final AppSession appSession = appSessionRepo.findOneByActive("00000000");
		assertNotNull(appSession);
		assertThat(appSession.getAttributes(), empty());
	}

	@Test
	public void unmapAttributeWithStringList() {
		final BasicDBList hendyList = new BasicDBList();
		final BasicDBObject doc = new BasicDBObject("attributes", new BasicDBObject("org___apache", hendyList));
		doc.put("className", AppSessionImpl.class.getName());
//		final AppSession appSession = appSessionRepo.fromDbObject(doc);
//		assertNotNull(appSession);
//		assertThat(appSession.getAttributes(), hasSize(1));
//		assertThat(appSession.getAttributes().map(), hasKey("org___apache"));
	}

}
