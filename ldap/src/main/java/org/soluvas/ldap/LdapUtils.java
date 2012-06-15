package org.soluvas.ldap;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.shared.ldap.model.entry.Attribute;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Value;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.message.ModifyRequestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;

/**
 * Manages {@link Entry} objects inside a base DN entry.
 * @author ceefour
 */
public class LdapUtils {
	
	private transient static Logger log = LoggerFactory.getLogger(LdapUtils.class);
	
	/**
	 * When updating {@link Person}, you should always exclude <tt>uid</tt> (the RDN) and <tt>userPassword</tt>
	 * attributes. 
	 * @param conn
	 * @param entry
	 * @param excludedAttributes
	 * @throws LdapException 
	 */
	public static void update(LdapConnection conn, Entry entry,
			boolean removeExtraAttributes, String... excludedAttributes) throws LdapException {
		log.info("Updating entry {}, removeExtraAttributes: {}, excludedAttributes: {}", new Object[] {
				entry.getDn(), removeExtraAttributes, excludedAttributes });
		Entry existing = conn.lookup(entry.getDn());

		ImmutableSet<String> excludedAttributeSet = ImmutableSet.copyOf(excludedAttributes);
		
		ModifyRequestImpl req = new ModifyRequestImpl();
		req.setName(entry.getDn());
		for (Attribute a : entry) {
			if ("objectClass".equalsIgnoreCase(a.getId()))
				continue;
			if (excludedAttributeSet.contains(a.getId()))
				continue;
			ImmutableSet<Value<?>> newValues = ImmutableSet.copyOf(a);
			if (existing.containsAttribute(a.getId())) {
				// make sure the new values are different, or ignore
				ImmutableSet<Value<?>> oldValues = ImmutableSet.copyOf( existing.get(a.getId()) );
				if (oldValues.equals(newValues))
					continue;
			}
			log.debug("Replace {} in {} with {}", new Object[] {
					a.getId(), entry.getDn(), newValues });
			req.replace(a);
		}
		if (removeExtraAttributes) {
			for (Attribute a : existing) {
				if ("objectClass".equalsIgnoreCase(a.getId()))
					continue;
				if (excludedAttributeSet.contains(a.getId()))
					continue;
				if (!entry.containsAttribute(a.getId())) {
					log.debug("Remove {} in {}", new Object[] {
							a.getId(), entry.getDn() });
					req.remove(a);
				}
			}
		}
		if (!req.getModifications().isEmpty()) {
			log.info("Modify {}: {}", entry.getDn(), req);
			conn.modify(req);
		} else {
			log.info("Not modifying {} because there are no changes", entry.getDn());
		}
	}

}
