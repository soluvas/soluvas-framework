package org.soluvas.image.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to list entities of {@link Media}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="media", name="ls", description="List Media entities.")
public class MediaLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(MediaLsCommand.class);
	
	@Option(name="--page", description="Page number.")
	private transient long pageNumber = 0;
	@Option(name="--pagesize", description="Page size.")
	private transient long pageSize = 100;
	@Option(name="--sort", description="Sort property.")
	private transient String sortProperty = "modificationTime";
	@Option(name="--sortdir", description="Sort direction.")
	private transient Direction sortDir = Direction.DESC;
	@Option(name="-a", aliases="--all", description="Shortcut to --status=RAW.")
	private Boolean all;
	@Option(name="--status", description="Status mask: RAW|ACTIVE_ONLY|INCLUDE_INACTIVE|DRAFT_ONLY|VOID_ONLY.")
	private transient StatusMask statusMask = StatusMask.ACTIVE_ONLY;
	
	@Override @Nullable
	protected Object doExecute() throws Exception {
		if (all != null && all) {
			statusMask = StatusMask.RAW;
		}
		final MediaRepository mediaRepo = getBean(MediaRepository.class);
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-15s|%-20s|%-9s|@",
				"№", "ID", "Status", "Name", "GUID" ));
		final Page<Media> mediaPage = mediaRepo.findAll(statusMask, new PageRequest(pageNumber, pageSize, sortDir, sortProperty));
		int i = 0;
		for (Media it : mediaPage.getContent()) {
			final String guidAnsi = NameUtils.shortenUuidAnsi(it.getGuid(), 9);
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-15s|@@|bold,black ||@%-15s@|bold,black ||@%-20s@|bold,black ||@" + guidAnsi,
				++i, it.getId(), it.getStatus(), it.getName()) );
		}
		System.out.println(ansi().render("@|bold,yellow %d|@ of @|bold,yellow %d|@ @|bold %s|@ Media entities",
				mediaPage.getNumberOfElements(), mediaPage.getTotalElements(), statusMask));
		return mediaPage.getTotalElements();
	}

}