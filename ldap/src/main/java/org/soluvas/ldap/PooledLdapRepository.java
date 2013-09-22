package org.soluvas.ldap;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.io.HexDump;
import org.apache.commons.pool.ObjectPool;
import org.apache.directory.api.ldap.codec.protocol.mina.LdapProtocolEncoder;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.cursor.SearchCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.exception.LdapInvalidAttributeValueException;
import org.apache.directory.api.ldap.model.filter.FilterEncoder;
import org.apache.directory.api.ldap.model.message.ModifyRequest;
import org.apache.directory.api.ldap.model.message.ModifyResponse;
import org.apache.directory.api.ldap.model.message.ResultCodeEnum;
import org.apache.directory.api.ldap.model.message.ResultResponse;
import org.apache.directory.api.ldap.model.message.SearchRequest;
import org.apache.directory.api.ldap.model.message.SearchRequestImpl;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionPool;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.CrudRepositoryBase;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * You need to call init() after creation.
 * This repository is thread-safe.
 * @author ceefour
 */
public class PooledLdapRepository<T> extends CrudRepositoryBase<T, String>
	implements LdapRepository<T> {

	protected static final class EntryDnFunction implements Function<Entry, Dn> {
		@Override @Nullable
		public Dn apply(@Nullable Entry input) {
			return input != null ? input.getDn() : null;
		}
	}

	private final class EntryToEntity implements Function<Entry, T> {
		@Override
		public T apply(Entry input) {
			return mapper.fromEntry(input, entityClass);
		}
	}

	private static Logger log = LoggerFactory.getLogger(PooledLdapRepository.class);
	
	@Inject
	private final ObjectPool<LdapConnection> pool;
	private final LdapMapper<T> mapper;
	private final String baseDn;
	private final Class<? extends T> entityClass;

	/**
	 * @param entityClass
	 * @param pool Make sure to call {@link LdapConnectionPool#setTestOnBorrow(boolean)} true.
	 * @param baseDn
	 */
	public PooledLdapRepository(final Class<? extends T> entityClass, final ObjectPool<LdapConnection> pool, final String baseDn) {
		super();
		this.entityClass = entityClass;
		this.pool = pool;
		this.baseDn = baseDn;
		this.mapper = new LdapMapper<>();
	}
	
	protected <V> V withConnection(final Function<LdapConnection, V> function) {
		return LdapUtils.withConnection(pool, function);
	}
	
	@Override @Deprecated
	public void init() {
		// No longer needed
	}
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public <S extends T> S add(S entity) {
		Preconditions.checkNotNull(entity, "Cannot add null object to %s, expected %s",
				baseDn, getEntityClass().getName());
		final Entry entry = mapper.toEntry(entity, baseDn);
		log.info("Add LDAP Entry {}: {}", entry.getDn(), entry);
		final Entry newEntry = withConnection(new Function<LdapConnection, Entry>() {
			@Override @Nullable
			public Entry apply(@Nullable LdapConnection conn) {
				try {
					conn.add(entry);
					log.debug("Lookup added LDAP Entry {}", entry.getDn());
					return conn.lookup(entry.getDn());
				} catch (LdapException e) {
					throw new LdapRepositoryException(e, "Error adding LDAP Entry %s", entry.getDn());
				}
			}
		});
		return (S) mapper.fromEntry(newEntry, entityClass);
	}
	
	/**
	 * Modify an LDAP {@link Entry} from typed POJO object.
	 * <tt>uid</tt> attribute cannot be replaced.
	 * @param entity
	 * @return
	 * @throws LdapException
	 */
	@Override @Nonnull
	public T modify(final T entity) {
		final String rdnValue = mapper.getRdnValue(entity);
		return modify(rdnValue, entity);
	}
	
	@Override
	public <S extends T> S modify(String id, final S entity) {
		Preconditions.checkNotNull(entity, "LDAP object to modify cannot be null");
//		final String dn = mapper.getDn(entity, baseDn);
		final String oldDn = mapper.getDn(id, entityClass, baseDn);
		log.info("Modify LDAP Entity {} with ID {} at {}", getEntityClass().getName(), id, oldDn); 
		final T modifiedObj = withConnection(new Function<LdapConnection, T>() {
			@Override @Nullable
			public T apply(@Nullable LdapConnection conn) {
				try {
					final String newDn = mapper.getDn(entity, baseDn);
					if (!oldDn.equals(newDn)) {
						final String newRdn = new Dn(newDn).getRdn().toString();
						log.info("Renaming LDAP Entity {} to {}", oldDn, newRdn);
						conn.rename(oldDn, newRdn);
					}
					
					final Entry existingEntry = conn.lookup(newDn);
					if (existingEntry == null) {
						throw new LdapRepositoryException("Cannot find LDAP Entry to modify: " + newDn);
					}
					final T existing = mapper.fromEntry(existingEntry, entityClass);
					final ModifyRequest modifyRequest = mapper.createModifyRequest(existingEntry, existing, entity);
					if (modifyRequest.getModifications().isEmpty()) {
						log.info("Not modifying unmodified LDAP Entry {}", newDn);
						return existing;
					} else {
						log.debug("Modifying LDAP Entry {} with {}", newDn, modifyRequest);
						final ModifyResponse modifyResponse = conn.modify(modifyRequest);
						if (modifyResponse.getLdapResult().getResultCode() == ResultCodeEnum.SUCCESS) {
							log.info("Modified LDAP Entry {} returned: {}", newDn, modifyResponse);
							final Entry modifiedEntry = conn.lookup(newDn);
							final T newObj = mapper.fromEntry(modifiedEntry, entityClass);
							return newObj;
						} else {
							throw new LdapRepositoryException("Error updating LDAP Entry " + newDn + ", result: " + modifyResponse);
						}
					}
				} catch (LdapException e) {
					throw new LdapRepositoryException(e, "Error updating LDAP Entry %s", oldDn);
				}
			}
		});
		return (S) modifiedObj;
	}

	/**
	 * Delete an LDAP entry based on ID, a {@link LdapRdn} annotated property, including all
	 * its subentries. Uses {@link LdapUtils#deleteRecursively(org.apache.directory.ldap.client.api.LdapConnection, String)}.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public boolean delete(String id) {
		final String dn = toDn(id);
		log.info("Deleting LDAP Entry {} recursively", dn); 
		try {
			return withConnection(new Function<LdapConnection, Boolean>() {
				@Override @Nullable
				public Boolean apply(@Nullable LdapConnection conn) {
					return LdapUtils.deleteRecursively(conn, dn) >= 1;
				}
			});
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error deleting LDAP Entry %s", dn);
		}
	}
	
	/**
	 * Find LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	@SuppressWarnings("unchecked") @Override
	public <U extends T> U findOne(String id) {
		final String dn = toDn(id);
		log.debug("Lookup LDAP Entry {}", dn); 
		final Entry entry = withConnection(new Function<LdapConnection, Entry>() {
			@Override @Nullable
			public Entry apply(@Nullable LdapConnection conn) {
				try {
					return conn.lookup(dn);
				} catch (LdapException e) {
					throw new LdapRepositoryException(e, "Error during lookup of LDAP Entry %s", dn);
				}
			}
		});
		if (entry != null) {
			T obj = mapper.fromEntry(entry, entityClass);
			return (U) obj;
		} else {
			log.trace("Lookup LDAP Entry " + dn + " returns nothing");
			return null;
		}
	}

	@Override
	public String toDn(String id) {
		return mapper.getDn(id, entityClass, baseDn);
	}
	
	/**
	 * Find LDAP entry based on an attribute value. The attribute does not need to be
	 * {@link LdapAttribute} annotated.
	 * 
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	@Override
	public T findOneByAttribute(String attribute, String value) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
		// Only search based on first objectClass, this is the typical use case
//		final String filter = "(&(objectClass=" + primaryObjectClass + ")(" + attribute + "=" + value + "))";
		final String filter = "(&(objectClass=*)(" + attribute + "=" + value + "))";
		log.debug("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			final Entry entry = withConnection(new Function<LdapConnection, Entry>() {
				@Override @Nullable
				public Entry apply(@Nullable LdapConnection conn) {
					try {
						List<Entry> entries = LdapUtils.asList(conn.search(baseDn, filter, SearchScope.ONELEVEL));
						return Iterables.getOnlyElement(entries, null);
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			if (entry != null) {
				log.debug("LDAP search {} filter {} returned {}", baseDn, filter, entry.getDn() );
				final T entity = mapper.fromEntry(entry, entityClass);
				return entity;
			} else {
				log.debug("LDAP search {} filter {} returned nothing", baseDn, filter);
				return null;
			}
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}
	
	/**
	 * Find LDAP entry IDs based on an attribute value. The attribute does not need to be
	 * {@link LdapAttribute} annotated.
	 * 
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	@Override
	public List<String> findIdsByAttribute(String attribute, String value) {
		final LdapMapping mapping = mapper.getMapping(entityClass);
		final String primaryObjectClass = mapping.getPrimaryObjectClass();
		// Only search based on first objectClass, this is the typical use case
//		final String filter = "(&(objectClass=" + primaryObjectClass + ")(" + attribute + "=" + value + "))";
		final String filter = "(&(objectClass=*)(" + attribute + "=" + value + "))";
		log.debug("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			final List<String> ids = withConnection(new Function<LdapConnection, List<String>>() {
				@Override @Nullable
				public List<String> apply(@Nullable LdapConnection conn) {
					try {
						final EntryCursor cursor = conn.search(baseDn, filter, SearchScope.ONELEVEL, mapping.getRdn().getName());
						try {
							final List<String> ids = LdapUtils.transform(cursor, new Function<Entry, String>() {
								@Override @Nullable
								public String apply(@Nullable Entry input) {
									return input.getDn().getRdn().getValue().getString();
								}
							});
							return ids;
						} finally {
							cursor.close();
						}
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			log.debug("LDAP search {} filter {} returned {} entries: {}", 
					baseDn, filter, ids.size(), Iterables.limit(ids, 10));
			return ids;
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}
	
	/**
	 * Find all LDAP entries of the same <tt>objectClass</tt>-es as the {@link LdapEntity}#objectClasses() annotation.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public List<T> findAll() {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
//		String filter = "(&";
//		for (String objectClass : objectClasses) {
//			filter += "(objectClass=" + objectClass + ")";
//		}
//		filter += ")";
		// Only search based on first objectClass, this is the typical use case
//		final String filter = "(objectClass=" + primaryObjectClass + ")";
		final String filter = "(objectClass=*)";
		log.debug("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			final List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						return LdapUtils.asList( conn.search(baseDn, filter, SearchScope.ONELEVEL) );
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			final List<Dn> limitedEntryDns = FluentIterable.from(entries).transform(new EntryDnFunction()).limit(10).toList();
			log.debug("LDAP search {} filter {} returned {} entries: {}", 
					baseDn, filter, entries.size(), limitedEntryDns );
			final List<T> entities = ImmutableList.copyOf(Lists.transform(entries, new Function<Entry, T>() {
				@Override
				public T apply(Entry input) {
					return mapper.fromEntry(input, entityClass);
				}
			}));
			return entities;
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}

	/**
	 * @return the shopDn
	 */
	@Override
	public String getBaseDn() {
		return baseDn;
	}

	/**
	 * @return the entityClass
	 */
	@Override
	public Class<? extends T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @return the mapper
	 */
	@Override
	public LdapMapper<T> getMapper() {
		return mapper;
	}

	public ObjectPool<LdapConnection> getPool() {
		return pool;
	}

	@Override
	public boolean exists(@Nullable String id) {
		if (Strings.isNullOrEmpty(id)) {
			// always false
			return false;
		}
		final String dn = toDn(id);
		return withConnection(new Function<LdapConnection, Boolean>() {
			@Override @Nullable
			public Boolean apply(@Nullable LdapConnection conn) {
				try {
					return conn.exists(dn);
				} catch (LdapException e) {
					Throwables.propagate(e);
					return false;
				}
			}
		});
	}

	@Override
	public List<T> search(@Nullable String searchText) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
		final String filter;
		if (!Strings.isNullOrEmpty(searchText)) {
			final String encodedSearchText = FilterEncoder.encodeFilterValue(searchText);
	//		String filter = "(&";
	//		for (String objectClass : objectClasses) {
	//			filter += "(objectClass=" + objectClass + ")";
	//		}
	//		filter += ")";
			// Only search based on first objectClass, this is the typical use case
			// escape searchText using https://issues.apache.org/jira/browse/DIRSHARED-143
	//		final String filter = String.format("(&(objectClass=%s)(|(cn=*%s*)(gn=*%s*)(sn=*%s*)(uid=*%s*)(mail=*%s*)))",
	//				primaryObjectClass, encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText);
			// TODO: change index config so that uid is also sub,subinitial,subany
			filter = String.format("(&(objectClass=*)(|(uid=%s)(cn=*%s*)(gn=*%s*)(sn=*%s*)(mail=*%s*)(o=*%s*)))",
					encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText);
		} else {
			filter = "(objectClass=*)";
		}
		log.debug("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			final List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						final SearchRequest req = new SearchRequestImpl();
						req.setBase(new Dn(baseDn));
						req.setFilter(filter);
						req.setScope(SearchScope.ONELEVEL);
						req.setSizeLimit(20);
						return LdapUtils.asList(conn.search(req));
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			final Ordering<Entry> cnOrdering = new Ordering<Entry>() {
				@Override
				public int compare(@Nullable Entry left, @Nullable Entry right) {
					try {
						final String leftCn = left.containsAttribute("cn") ? left.get("cn").getString() : "";
						final String rightCn = right.containsAttribute("cn") ? right.get("cn").getString() : "";
						return leftCn.compareToIgnoreCase(rightCn);
					} catch (LdapInvalidAttributeValueException e) {
						return 0;
					}
				}
			}; 
			final List<Entry> sortedEntries = cnOrdering.immutableSortedCopy(entries);
			final List<Dn> limitedEntryDns = FluentIterable.from(sortedEntries).transform(new EntryDnFunction()).limit(10).toList();
			log.debug("LDAP search {} filter {} returned {} entries: {}", 
					baseDn, filter, entries.size(), limitedEntryDns);
			final List<T> entities = Lists.transform(sortedEntries, new EntryToEntity());
			return entities;
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}

	@Override
	public boolean existsByAttribute(String attribute, String value) {
		final T found = findOneByAttribute(attribute, value);
		return found != null;
	}

	@Override
	public List<T> findAllByFilter(String filter) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
//		final String realFilter = String.format("(&(objectClass=%s)%s)",
//				primaryObjectClass, filter);
		final String realFilter = String.format("(&(objectClass=*)%s)",
				filter);
		log.debug("Searching LDAP {} filter: {}", baseDn, realFilter); 
		try {
			final List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						return LdapUtils.asList( conn.search(baseDn, realFilter, SearchScope.ONELEVEL) );
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			final List<Dn> limitedEntryDns = FluentIterable.from(entries).transform(new EntryDnFunction()).limit(10).toList();
			log.debug("LDAP search {} filter {} returned {} entries: {}", 
					baseDn, filter, entries.size(), limitedEntryDns);
			final List<T> entities = Lists.transform(entries, new EntryToEntity());
			return entities;
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}

	@Override
	public long count() {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
		// Only search based on first objectClass, this is the typical use case
//		final String filter = "(objectClass=" + primaryObjectClass + ")";
		final String filter = "(objectClass=*)";
		log.debug("Counting LDAP {} filter: {}", baseDn, filter); 
		try {
			final Long entries = withConnection(new Function<LdapConnection, Long>() {
				@Override @Nullable
				public Long apply(@Nullable LdapConnection conn) {
					EntryCursor cursor = null;
					try {
						cursor = conn.search(baseDn, filter, SearchScope.ONELEVEL);
						return (long) Iterables.size(cursor);
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					} finally {
						if (cursor != null) {
							cursor.close();
						}
					}
				}
			});
			log.debug("LDAP count {} filter {} returned {} entries", baseDn, filter, entries);
			return entries;
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}

	@Override @Nullable
	protected String getId(T entity) {
		return mapper.getRdnValue(entity);
	}

	@Override
	public long countByAttribute(String attribute, String value) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
		// Only search based on first objectClass, this is the typical use case
//		final String filter = "(objectClass=" + primaryObjectClass + ")";
		final String filter = "(&(objectClass=*)(" + attribute + "=" + value + "))";
		log.debug("Counting LDAP {} filter: {}", baseDn, filter); 
		try {
			final Long entries = withConnection(new Function<LdapConnection, Long>() {
				@Override @Nullable
				public Long apply(@Nullable LdapConnection conn) {
					EntryCursor cursor = null;
					try {
						cursor = conn.search(baseDn, filter, SearchScope.ONELEVEL);
						return (long) Iterables.size(cursor);
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					} finally {
						if (cursor != null) {
							cursor.close();
						}
					}
				}
			});
			log.debug("LDAP count {} filter {} returned {} entries", baseDn, filter, entries);
			return entries;
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}
	
	@Override
	public Page<T> findAll(final Pageable pageable) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
//		String filter = "(&";
//		for (String objectClass : objectClasses) {
//			filter += "(objectClass=" + objectClass + ")";
//		}
//		filter += ")";
		// Only search based on first objectClass, this is the typical use case
//		final String filter = "(objectClass=" + primaryObjectClass + ")";
//		final String filter = "(objectClass=*)";
		final String filter = "(sn=*)";
		log.debug("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			final List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						SearchRequestImpl search = new SearchRequestImpl();
//						search.setBase(new Dn(baseDn));
						search.setBase(new Dn("dc=dev,dc=tuneeca,dc=com"));
						search.setFilter(filter);
						search.setScope(SearchScope.ONELEVEL);
						String sortProperty = pageable.getSort().iterator().next().getProperty();
						ServerSideSortImpl skl = new ServerSideSortImpl(sortProperty);
//						ASN1EncodableVector innerVector = new ASN1EncodableVector();
//						innerVector.add(new BERConstructedOctetString(sortProperty.getBytes(Charsets.UTF_8)));
//						BERSequence innerSeq = new BERSequence(innerVector);
//						ASN1EncodableVector outerVector = new ASN1EncodableVector();
//						outerVector.add(innerSeq);
//						BERSequence outerSeq = new BERSequence(outerVector);
//						OpaqueControl skl = new OpaqueControl(ServerSideSort.OID);
//						final byte[] outerBer = innerSeq.getEncoded("BER");
//						HexDump.dump(outerBer, 0, System.out, 0);
//						log.info("SSS control: {} | '{}'", outerBer, new String(outerBer));
//						skl.setEncodedValue(outerBer);
//						skl.setEncodedValue(new byte[] { 0x04, 0x08, 0x30, 0x06, 0x30, 0x04, 0x04, 0x02, 0x73, 0x6e });
//						log.info("SKL has encoded value: {}", skl.hasEncodedValue());
						search.addControl(skl);

						// debug stuff
						ProtocolCodecSession session = new ProtocolCodecSession();
						ProtocolEncoder encoder = new LdapProtocolEncoder();
						encoder.encode(session, search, session.getEncoderOutput());
						IoBuffer buffer = (IoBuffer) session.getEncoderOutputQueue().poll();
						HexDump.dump(buffer.array(), 0, System.out, 0);
						// debug stuff
						
						SearchCursor searchCursor = conn.search(search);
						try {
							searchCursor.next();
							ResultResponse done = searchCursor.getSearchResultDone(); 
							if (done != null && done.getLdapResult() != null &&
									done.getLdapResult().getResultCode() != ResultCodeEnum.SUCCESS) {
								throw new LdapException(String.format("Cannot search %s using %s: %s %s",
										baseDn, filter, done.getLdapResult().getResultCode(), done.getLdapResult().getDiagnosticMessage()));
							}
							return LdapUtils.asList( searchCursor );
						} finally {
							searchCursor.close();
						}
					} catch (Exception e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			final List<Dn> limitedEntryDns = FluentIterable.from(entries).transform(new EntryDnFunction()).limit(10).toList();
			log.debug("LDAP search {} filter {} returned {} entries: {}", 
					baseDn, filter, entries.size(), limitedEntryDns);
			final List<T> entities = ImmutableList.copyOf(Lists.transform(entries, new Function<Entry, T>() {
				@Override
				public T apply(Entry input) {
					return mapper.fromEntry(input, entityClass);
				}
			}));
			return new PageImpl<T>(entities);
		} catch (Exception e) {
			throw new LdapRepositoryException(e, "Error searching LDAP in %s filter %s", baseDn, filter);
		}
	}
	
}
