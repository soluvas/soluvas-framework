package org.soluvas.ldap;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.picketlink.idm.api.User;
import org.soluvas.json.JsonUtils;

import com.google.common.collect.ImmutableSet;

/**
 * A basic LDAP <tt>objectClass=person</tt> with proper mappings that can be subclassed.
 * @author ceefour
 */
@SuppressWarnings("serial")
@LdapEntry(objectClasses={"organizationalPerson", "uidObject", "extensibleObject"})
public class PersonWithLong implements Serializable, User {

	@LdapRdn @LdapAttribute("uid") @NotNull private String id;
	@LdapAttribute("uniqueIdentifier") private String slug;
	@LdapAttribute("gn") private String firstName;
	@LdapAttribute("sn") @NotNull private String lastName;
	@LdapAttribute("cn") @NotNull private String name;
	@LdapAttribute("userPassword") private String password;
	@LdapAttribute("mail") private Set<String> emails;
	@LdapAttribute("magentoId") private Long magentoId;
	
	public Long getMagentoId() {
		return magentoId;
	}

	public void setMagentoId(Long magentoId) {
		this.magentoId = magentoId;
	}

	public PersonWithLong() {
	}
	
	public PersonWithLong(String id, String slug, String firstName, String lastName) {
		super();
		this.id = id;
		this.slug = slug;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = (firstName + " " + lastName).trim();
	}

	public PersonWithLong(String id, String slug, String firstName, String lastName, String email) {
		this(id, slug, firstName, lastName);
		this.emails = email != null ? ImmutableSet.of(email) : new HashSet<String>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the emails
	 */
	public Set<String> getEmails() {
		return emails;
	}
	
	/**
	 * @param emails the emails to set
	 */
	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return JsonUtils.asJson(this);
	}

	/**
	 * Implements PicketLink IDM API {@link User}.
	 */
	@Override
	public String getKey() {
		return getId();
	}

}
