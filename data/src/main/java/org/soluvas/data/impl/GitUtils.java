package org.soluvas.data.impl;

import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig.Host;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Session;

/**
 * Disable strict host key checking: http://stackoverflow.com/a/13397058/122441.
 * @author ceefour
 */
public class GitUtils {

	private static final Logger log = LoggerFactory.getLogger(GitUtils.class);
	private static boolean strictHostKeyCheckingDisabled = false;

	/**
	 * Disable strict host key checking: http://stackoverflow.com/a/13397058/122441. 
	 */
	public static void disableStrictHostKeyChecking() {
		if (!strictHostKeyCheckingDisabled) {
			log.info("Disabling JGit/Jsch strict host key checking");
			strictHostKeyCheckingDisabled = true;
			SshSessionFactory.setInstance(new JschConfigSessionFactory() {
				@Override
				protected void configure(Host hc, Session session) {
					session.setConfig("StrictHostKeyChecking", "no");
				}
			});
		}
	}
	
}
