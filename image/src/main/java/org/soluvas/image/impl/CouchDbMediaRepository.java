package org.soluvas.image.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.ektorp.AttachmentInputStream;
import org.soluvas.couchdb.CouchDbRepositoryBase;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.push.RepositoryException;
import org.soluvas.data.repository.Repository;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;
import org.soluvas.image.MediaStatus;

import scala.util.Try;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * {@link Media} {@link Repository} via CouchDB native attachments support.
 * @author ceefour
 */
public class CouchDbMediaRepository extends CouchDbRepositoryBase<Media, MediaStatus>
		implements MediaRepository {

	public CouchDbMediaRepository(ClientConnectionManager connMgr,
			String couchDbUri, String dbName) {
		super(connMgr, Media.class, MediaImpl.class, 1L, couchDbUri, dbName,
				"media", ImmutableList.<String>of(), ImmutableMap.<String, Integer>of(),
				"status", 
				ImmutableSet.of(MediaStatus.BOOKED),
				ImmutableSet.<MediaStatus>of(),
				ImmutableSet.of(MediaStatus.DRAFT),
				ImmutableSet.of(MediaStatus.VOID) );
	}
	
	protected void attach(Media media, File file, String contentType) throws IOException {
		final String guid = Preconditions.checkNotNull(media.getGuid(), "GUID for media '%s' must be not null", media.getId());
		final String revision = Preconditions.checkNotNull(media.getRevision(), "Revision for media '%s' must be not null", media.getId());
		log.debug("Adding attachment '%s' (%s) to media '{}' _id={} _rev={}",
				file, contentType, media.getId(), guid, revision);
		try (AttachmentInputStream attachmentInputStream = new AttachmentInputStream(file.getName(), FileUtils.openInputStream(file), contentType)) {
			dbConn.createAttachment(guid, revision, attachmentInputStream);
		}
	}
	
	protected void attach(String id, File file, String contentType) throws IOException {
		final Media media = Preconditions.checkNotNull(findOne(id),
				"Cannot find media '%s'", id);
		attach(media, file, contentType);
	}

	@Override
	public Media add(Media media, File file, String contentType) {
		final Media added = add(media);
		try {
			attach(added, file, contentType);
			final Media attached = Preconditions.checkNotNull(findOne(added.getId()),
					"Cannot find media '%s'", added.getId());
			return attached;
		} catch (IOException e) {
			throw new RepositoryException(e, "Cannot add media '%s' from '%s'", 
					added.getId(), file);
		}
	}
	
	@Override
	public Media add(Media media, File file) {
		try {
			final String contentType = Files.probeContentType(file.toPath());
			return add(media, file, contentType);
		} catch (IOException e) {
			throw new RepositoryException(e, "Cannot probe content type from '%s' for media '%s'", 
					file, media.getId());
		}
	}

	@Override
	public <S extends Media, K extends Serializable> S lookupOne(
			StatusMask statusMask, LookupKey lookupKey, K key)
			throws EntityLookupException {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Media, K extends Serializable> Map<K, Try<S>> lookupAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <K extends Serializable> Existence<K> checkExists(StatusMask statusMask,
			LookupKey lookupKey, K key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TrashResult trash(Media entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TrashResult trashById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Try<TrashResult>> trashAll(Collection<Media> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Try<TrashResult>> trashAllByIds(Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UntrashResult untrash(Media entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UntrashResult untrashById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAll(Collection<Media> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAllByIds(
			Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug) {
		throw new UnsupportedOperationException();
	}

}
