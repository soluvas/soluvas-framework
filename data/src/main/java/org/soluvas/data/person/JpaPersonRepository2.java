package org.soluvas.data.person;

import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.data.StatusMask;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * Created by ceefour on 01/03/2016.
 */
@Repository
public class JpaPersonRepository2 implements PersonRepository2 {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public Optional<String> getIdForSlugOrEmail(String tenantId, String slugOrEmail) {
        final String canonicalSlug = SlugUtils.canonicalize(slugOrEmail);
        try {
            return Optional.of(em.createQuery("SELECT p.id FROM QuikdoPerson p WHERE p.tenantId=:tenantId AND p.canonicalSlug=:canonicalSlug OR p.email=:lowerEmail", String.class)
                    .setParameter("tenantId", tenantId)
                    .setParameter("canonicalSlug", canonicalSlug)
                    .setParameter("lowerEmail", slugOrEmail.toLowerCase())
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Person> findOne(String tenantId, StatusMask statusMask, String personId) {
        // FIXME: implement this
        return Optional.empty();
    }
}
