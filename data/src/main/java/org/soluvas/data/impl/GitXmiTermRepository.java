package org.soluvas.data.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.soluvas.data.DataException;

import com.google.common.base.Function;
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
	
}
