package org.soluvas.data.person;

import org.soluvas.commons.Person;
import org.soluvas.data.SlugLookup;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * {@link Person} repository that supports paging and sorting.
 * @author ceefour
 */
public interface PersonRepository extends
		PagingAndSortingRepository<Person, String>, SlugLookup<Person> {

}
