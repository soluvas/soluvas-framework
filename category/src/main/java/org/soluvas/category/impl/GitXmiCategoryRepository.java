package org.soluvas.category.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.PushResult;
import org.joda.time.DateTime;
import org.soluvas.commons.tenant.TenantDirProvision;
import org.soluvas.commons.util.GitUtils;
import org.soluvas.data.DataException;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;

/**
 * Extension of {@link XmiCategoryRepository} that commits the underlying Git repository
 * on every XMI catalog modification. Also optionally supports pull+push.
 * <p>Note in order for commit and pull/push to work:
 * <ul>
 * 	<li>Host key must be properly known.</li>
 * 	<li>Git author name and email must be set. This is required by commit.</li>
 * 	<li>Git default remote and branch to pull/push must be set. This is required by pull and push.</li>
 * </ul>
 * <p>In short, test simple commit, pull, and push using the git command line. If that works
 * then this should work too. 
 * @author ceefour
 */
public class GitXmiCategoryRepository extends XmiCategoryRepository {
	
	private Map<String, Repository> gitRepos;
	private TenantDirProvision tenantDirProvision;

	public GitXmiCategoryRepository(
			List<URL> xmiResources, Map<String, File> xmiFiles, EventBus eventBus, TenantDirProvision tenantDirProvision) {
		super(xmiResources, xmiFiles, eventBus);
		this.tenantDirProvision = tenantDirProvision;
		if (tenantDirProvision == TenantDirProvision.WORKSPACE) {
			return;
		}
		GitUtils.disableStrictHostKeyChecking();
		this.gitRepos = ImmutableMap.copyOf(Maps.transformValues(xmiFiles, new Function<File, Repository>() {
			@Override @Nullable
			public Repository apply(@Nullable File input) {
				try {
					final File xmiParent = input.getParentFile().getCanonicalFile();
					return new RepositoryBuilder().findGitDir(xmiParent).setMustExist(true)
						.build();
				} catch (IOException e) {
					throw new DataException(e, "Cannot get Git Repository for %s", input);
				}
			}
		}));
	}
	
	@Override
	protected void catalogFilesChanged(Set<String> nsPrefixes, String message) {
		super.catalogFilesChanged(nsPrefixes, message);
		if (tenantDirProvision == TenantDirProvision.WORKSPACE) {
			return;
		}
		try {
			for (final String nsPrefix : nsPrefixes) {
				final Repository gitRepo = Preconditions.checkNotNull(gitRepos.get(nsPrefix),
						"Cannot get Git repository for %s", nsPrefix);
				log.debug("Committing '{}' in {}", message, gitRepo);
				final Git git = new Git(gitRepo);
//				final DirCache addCache = git.add().addFilepattern(".").setUpdate(true).call();
				final RevCommit revCommit = git.commit().setAll(true).setMessage(message + "\nChanged catalog nsPrefixes: " + nsPrefixes + " at " + new DateTime()).call();
				log.info("Committed '{}' as {} in {}", message, revCommit, gitRepo);
				
				// pull
				log.debug("Pulling {} due to '{}'", gitRepo, message);
				final PullResult pullResult = git.pull().call();
				// FetchResult doesn't have proper toString()
				final String fetchResult = pullResult.getFetchResult() != null ? pullResult.getFetchResult().getTrackingRefUpdates() + " from " + pullResult.getFetchResult().getURI() : null;
				log.info("Pulled {} from {}. Fetch: {}. Merge: {}.", gitRepo, pullResult.getFetchedFrom(), fetchResult,
						pullResult.getMergeResult());
				// push: MUST set default remote AND branch
				log.debug("Pushing {} due to '{}'", gitRepo, message);
				final Iterable<PushResult> pushResults = git.push().call();
				log.info("Pushed {}: {}", gitRepo, pushResults);
			}
		} catch (GitAPIException e) {
			throw new DataException(e, "Cannot commit '%s' to Git repository: %s", message, e);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GitXmiCategoryRepository ["
				+ (xmiResources != null ? "xmiResources=" + xmiResources + ", "
						: "")
				+ (xmiFiles != null ? "xmiFiles=" + xmiFiles : "") + "]";
	}

}
