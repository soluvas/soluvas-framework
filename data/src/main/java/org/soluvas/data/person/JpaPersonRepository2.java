package org.soluvas.data.person;

import org.soluvas.commons.Person;

import java.util.Optional;

/**
 * Created by ceefour on 01/03/2016.
 */
public class JpaPersonRepository2 implements PersonRepository2 {
    @Override
    public Optional<Person> findOne(String tenantId, String personId) {
        // FIXME: implement this
        return Optional.empty();
    }
}
