package org.soluvas.data.person;

import com.google.common.base.Preconditions;
import org.soluvas.commons.*;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Environment property {@code person.class} is required, it's also required by {@code commands/person.groovy}
 * Created by ceefour on 01/03/2016.
 */
@Repository
public class JpaPersonRepository2 implements PersonRepository2 {

    private Class<? extends Person2> entityClass;

    @Inject
    private Environment env;
    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        try {
            this.entityClass = (Class<? extends Person2>) JpaPersonRepository2.class.forName(env.getRequiredProperty("person.class"));
        } catch (ClassNotFoundException e) {
            throw new CommonsException(e, "Cannot get property 'person.class'");
        }
    }

    @Override
    public Person2 newBlank() {
        try {
            return entityClass.newInstance();
        } catch (Exception e) {
            throw new CommonsException(e, "Cannot create instance of %s", entityClass.getName());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<String> getIdForSlugOrEmail(String tenantId, String slugOrEmail) {
        try {
            final String canonicalSlug = SlugUtils.canonicalize(slugOrEmail);
            return Optional.of(em.createQuery("SELECT p.id FROM Person p LEFT JOIN p.emails e" +
                    " WHERE p.tenantId=:tenantId AND (p.canonicalSlug=:canonicalSlug OR e.email=:lowerEmail)", String.class)
                    .setParameter("tenantId", tenantId)
                    .setParameter("canonicalSlug", canonicalSlug)
                    .setParameter("lowerEmail", slugOrEmail.toLowerCase())
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person2> findOne(String tenantId, StatusMask statusMask, String personId) {
        try {
            return Optional.of(em.createQuery("SELECT p FROM Person p" +
                    " WHERE p.tenantId=:tenantId AND p.id=:personId", entityClass)
                    .setParameter("tenantId", tenantId)
                    .setParameter("personId", personId)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Existence<String> existsBySlug(String tenantId, StatusMask statusMask, String upSlug) {
        try {
            final String canonicalSlug = SlugUtils.canonicalize(upSlug);
            final String id = em.createQuery("SELECT p.id FROM Person p" +
                    " WHERE p.tenantId=:tenantId AND p.canonicalSlug=:canonicalSlug", String.class)
                    .setParameter("tenantId", tenantId)
                    .setParameter("canonicalSlug", canonicalSlug)
                    .getSingleResult();
            return Existence.of(upSlug, id);
        } catch (NoResultException e) {
            return Existence.absent();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person2> findOneByEmail(String tenantId, StatusMask statusMask, String upEmail) {
        try {
            return Optional.of(em.createQuery("SELECT p FROM Person p LEFT JOIN p.emails e" +
                    " WHERE p.tenantId=:tenantId AND e.email=:lowerEmail", entityClass)
                    .setParameter("tenantId", tenantId)
                    .setParameter("lowerEmail", upEmail.toLowerCase())
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Person2 add(String tenantId, Person2 person) {
        person.setTenantId(tenantId);
        return em.merge(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person2> findOneBySlug(String tenantId, StatusMask statusMask, String upSlug) {
        final String canonicalSlug = SlugUtils.canonicalize(upSlug);
        try {
            return Optional.of(em.createQuery("SELECT p FROM Person p" +
                    " WHERE p.tenantId=:tenantId AND p.canonicalSlug=:canonicalSlug", entityClass)
                    .setParameter("tenantId", tenantId)
                    .setParameter("canonicalSlug", canonicalSlug)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Person2 modify(String tenantId, String personId, Person2 person) {
        Preconditions.checkArgument(tenantId.equals(person.getTenantId()));
        Preconditions.checkArgument(personId.equals(person.getId()));
        return em.merge(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Person2> findBySearchText(String tenantId, StatusMask statusMask, String term, PageRequest pageable) {
        final String termLike = term.toLowerCase().replaceAll("%", "\\%").replaceAll("_", "\\_") + "%";
        final long count = em.createQuery("SELECT COUNT(p.id) FROM Person p" +
                " WHERE p.tenantId=:tenantId AND LOWER(p.name) LIKE :termLike ESCAPE '\\'", Long.class)
                .setParameter("tenantId", tenantId)
                .setParameter("termLike", termLike)
                .getSingleResult();
        final List<Person2> list = (List) em.createQuery("SELECT p FROM Person p" +
                " WHERE p.tenantId=:tenantId AND LOWER(p.name) LIKE :termLike ESCAPE '\\'", entityClass)
                .setParameter("tenantId", tenantId)
                .setParameter("termLike", termLike)
                .setFirstResult(pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        return new PageImpl<Person2>(list, pageable, count);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person2> findAll(String tenantId, StatusMask statusMask, Collection<String> ids) {
        return (List) em.createQuery("SELECT p FROM Person p" +
                " WHERE p.tenantId=:tenantId AND p.id IN :ids", entityClass)
                .setParameter("tenantId", tenantId)
                .setParameter("ids", ids)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public long count(String tenantId, StatusMask statusMask) {
        // FIXME: implement
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Person2> findAll(String tenantId, StatusMask statusMask, Pageable pageable) {
        // FIXME: implement
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public long countAllByKeywordAndRoles(String keyword, Collection<AccountStatus> accountStatuses, CustomerRole customerRole, Collection<String> customerRoleIds) {
        // FIXME: implement
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Person2> findAllByKeywordAndRoles(String keyword, Collection<AccountStatus> accountStatuses, CustomerRole customerRole, Collection<String> securityRoleIds, PageRequest pageable) {
        // FIXME: implement
        return null;
    }

}
