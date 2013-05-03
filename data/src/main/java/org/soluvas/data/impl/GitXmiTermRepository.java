package org.soluvas.data.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.revwalk.RevCommit;
import org.joda.time.DateTime;
import org.soluvas.data.DataException;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;


/**
 * Extension of {@link XmiTermRepository} that commits the underlying Git repository
 * on every XMI catalog modification. Also optionally supports pull+push.
 * @author ceefour
 */
public class GitXmiTermRepository 
		extends XmiTermRepository {
	
	private Map<String, Repository> gitRepos;

	public GitXmiTermRepository(String kindNsPrefix, String kindName,
			List<URL> xmiResources, Map<String, File> xmiFiles) {
		super(kindNsPrefix, kindName, xmiResources, xmiFiles);
		this.gitRepos = ImmutableMap.copyOf(Maps.transformValues(xmiFiles, new Function<File, Repository>() {
			@Override @Nullable
			public Repository apply(@Nullable File input) {
				try {
					return new RepositoryBuilder().findGitDir(input.getParentFile()).setMustExist(true)
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
		try {
			for (final String nsPrefix : nsPrefixes) {
				final Repository gitRepo = Preconditions.checkNotNull(gitRepos.get(nsPrefix),
						"Cannot get Git repository for %s", nsPrefix);
				final Git git = new Git(gitRepo);
//				final DirCache addCache = git.add().addFilepattern(".").setUpdate(true).call();
				final RevCommit revCommit = git.commit().setAll(true).setMessage(message + "\nChanged catalog nsPrefixes: " + nsPrefixes + " at " + new DateTime()).call();
				log.info("Committed '{}' as {} in {}", message, revCommit, gitRepo);
			}
		} catch (GitAPIException e) {
			throw new DataException(e, "Cannot commit '%s' to Git repository: %s", message, e);
		}
	}
}
