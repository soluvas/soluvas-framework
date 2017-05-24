package org.soluvas.data.person;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Person2;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

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

    Optional<Person2> findOneBySlug(String tenantId, StatusMask statusMask, String upSlug);

    Person2 modify(String tenantId, String personId, Person2 person);

    Page<Person2> findBySearchText(String tenantId, StatusMask statusMask, String term, PageRequest pageable);

    List<Person2> findAll(String tenantId, StatusMask statusMask, Collection<String> ids);

    long count(String tenantId, StatusMask statusMask);
    Page<Person2> findAll(String tenantId, StatusMask statusMask, Pageable pageable);

    long countAllByKeywordAndRoles(String tenantId, String keyword,
                                   Collection<AccountStatus> accountStatuses,
                                   CustomerRole2 customerRole, Collection<String> securityRoleIds);
    Page<Person2> findAllByKeywordAndRoles(String tenantId, String keyword, Collection<AccountStatus> accountStatuses, CustomerRole2 customerRole, Collection<String> securityRoleIds, PageRequest pageable);

}
