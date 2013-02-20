package org.soluvas.commons.impl;

import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Nonnull;

import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.XmiTracker;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/**
 * Used by {@link XmiTracker} and friends.
 * @author ceefour
 */
public class XmiTrackerUtils {

	private static final Logger log = LoggerFactory
			.getLogger(XmiTrackerUtils.class);
	
	/**
	 * Scan a bundle for {suppliedClassSimpleName}.xmi files both in root and in the package.
	 * @param bundle
	 * @param suppliedClassSimpleName
	 * @return
	 */
	public static List<URL> scan(@Nonnull final Bundle bundle, @Nonnull final String suppliedClassSimpleName) {
		final Builder<URL> scannedsBuilder = ImmutableList.builder();
		
		final String filePattern = "*." + suppliedClassSimpleName + ".xmi";
		log.trace("Scanning {} [{}] for {}", bundle.getSymbolicName(), bundle.getBundleId(),
				filePattern);
		final String path = bundle.getSymbolicName().replace('.', '/');
		
		final Enumeration<URL> rootEntries = bundle.findEntries("", filePattern, false);
		while (rootEntries != null && rootEntries.hasMoreElements()) {
			scannedsBuilder.add(rootEntries.nextElement());
		}
		
		final Enumeration<URL> innerEntries = bundle.findEntries(path, filePattern, false);
		while (innerEntries != null && innerEntries.hasMoreElements()) {
			scannedsBuilder.add(innerEntries.nextElement());
		}
		
		return scannedsBuilder.build();
	}
	
}
