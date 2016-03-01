package org.soluvas.data.person;

import org.soluvas.commons.Person;
import org.soluvas.data.StatusMask;

import java.util.Optional;

/**
 * App-scoped and tenant-scoped aware successor of {@link PersonRepository}.
 * Created by ceefour on 01/03/2016.
 */
public interface PersonRepository2 {

    Optional<Person> findOne(String tenantId, StatusMask statusMask, String personId);

}
