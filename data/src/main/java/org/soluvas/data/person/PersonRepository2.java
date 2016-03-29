package org.soluvas.data.person;

import org.soluvas.commons.Person2;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * App-scoped and tenant-scoped aware successor of {@link PersonRepository}.
 * Created by ceefour on 01/03/2016.
 */
public interface PersonRepository2 {

    Person2 newBlank();

    Optional<String> getIdForSlugOrEmail(String tenantId, String slugOrEmail);

    Optional<Person2> findOne(String tenantId, StatusMask statusMask, String personId);

    Existence<String> existsBySlug(String tenantId, StatusMask statusMask, String upSlug);

    @Transactional(readOnly = true)
    Optional<Person2> findOneByEmail(String tenantId, StatusMask statusMask, String upEmail);

    @Transactional
    Person2 add(String tenantId, Person2 person);
}
