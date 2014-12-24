package org.soluvas.image.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.ektorp.AttachmentInputStream;
import org.ektorp.CouchDbConnector;
import org.soluvas.commons.WebAddress;
import org.soluvas.couchdb.CouchDbRepositoryBase;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.push.RepositoryException;
import org.soluvas.data.repository.Repository;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;
import org.soluvas.image.MediaStatus;
import org.soluvas.image.rs.MediaResource;

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
	
	private final WebAddress webAddress;

	public CouchDbMediaRepository(CouchDbConnector dbConn,
			String dbName, WebAddress webAddress) {
		super(dbConn, Media.class, MediaImpl.class, 1L, dbName,
				ImmutableList.<String>of(), ImmutableMap.<String, Integer>of(),
				DeleteMethod.DELETE,
				"status",
				ImmutableSet.of(MediaStatus.BOOKED),
				ImmutableSet.<MediaStatus>of(),
				ImmutableSet.of(MediaStatus.DRAFT), ImmutableSet.of(MediaStatus.VOID) );
		this.webAddress = webAddress;
	}
	
	protected void attach(Media media, File file, String contentType) throws IOException {
		Preconditions.checkNotNull(media.getId(), "ID for media must be not null");
		final String name = Preconditions.checkNotNull(media.getName(), "Name for media '%s' must be not null", media.getId());
		final String guid = Preconditions.checkNotNull(media.getGuid(), "GUID for media '%s' must be not null", media.getId());
		final String revision = Preconditions.checkNotNull(media.getRevision(), "Revision for media '%s' must be not null", media.getId());
		log.debug("Adding attachment '%s' (%s) as '%s' to media '{}' _id={} _rev={}",
				file, contentType, name, media.getId(), guid, revision);
		try (AttachmentInputStream attachmentInputStream = new AttachmentInputStream(name, FileUtils.openInputStream(file), contentType)) {
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
	public String getPublicUri(Media media) {
		return getOriginUri(media);
	}
	
	@Override
	public String getOriginUri(Media media) {
//		return couchDbUri + dbName + "/" + media.getGuid() + "/" + media.getAttachments().keySet().iterator().next();
		return UriBuilder.fromUri(webAddress.getApiUri())
				.path(MediaResource.class)
				.path(MediaResource.class, "getContent")
				.build(media.getId()).toString();
	}
	
	@Override
	public Response getContent(Media media) throws IOException {
		final String attachmentId = media.getAttachments().keySet().iterator().next();
		try (final AttachmentInputStream attachment = dbConn.getAttachment(media.getGuid(), attachmentId)) {
			final byte[] bytes = IOUtils.toByteArray(attachment);
			return Response.ok(bytes, attachment.getContentType())
					.header("Content-Disposition", "inline; filename=" + attachmentId)
					.build();
		}
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
