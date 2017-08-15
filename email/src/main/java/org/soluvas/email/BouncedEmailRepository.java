package org.soluvas.email;

import java.util.Collection;
import java.util.Map;

import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.mongo.MongoRepository;

/**
 * @author eki
 *
 */
public interface BouncedEmailRepository extends PagingAndSortingRepository<BouncedEmail, String>, MongoRepository<BouncedEmail> {

	Map<String, Boolean> existsByEmails(Collection<String> emailList);

	boolean existByEmail(String email);

	BouncedEmail findByEmail(String trim);

}
