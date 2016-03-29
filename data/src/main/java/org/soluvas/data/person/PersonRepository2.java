package org.soluvas.data.person;

import org.soluvas.commons.Person2;
import org.soluvas.data.StatusMask;

import java.util.Optional;

/**
 * App-scoped and tenant-scoped aware successor of {@link PersonRepository}.
 * Created by ceefour on 01/03/2016.
 */
public interface PersonRepository2 {

    Optional<String> getIdForSlugOrEmail(String tenantId, String slugOrEmail);

    Optional<Person2> findOne(String tenantId, StatusMask statusMask, String personId);

}
