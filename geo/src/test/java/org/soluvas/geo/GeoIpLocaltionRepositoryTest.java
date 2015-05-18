package org.soluvas.geo;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rudi
 *
 */
public class GeoIpLocaltionRepositoryTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(GeoIpLocaltionRepositoryTest.class);

	@Test
	public void generateInetAddress() throws UnknownHostException  {
//		final String ipRange = "139.193.12.0/255";
//		final String ipStart = ipRange.substring(0, ipRange.indexOf("/") - 2);
//		log.info("ipStart for '{}': {}", ipRange, ipStart);
//		final String ip = "139.193.12.60";
//		final String ipQuery = ip.substring(0, ip.lastIndexOf("."));
//		log.info("ipQuery for '{}': {}", ip, ipQuery);
		
		final String ipRange = "2001:240:180::/41";
		final String ipStart = ipRange.substring(0, ipRange.indexOf("/") - 2);
		log.info("ipStart for '{}': {}", ipRange, ipStart);
		final String ip = "2001:208:5::2";
		final String ipQuery = ip.substring(0, ip.lastIndexOf("::"));
		log.info("ipQuery for '{}': {}", ip, ipQuery);
		
		final InetAddress inetAddress = InetAddress.getByName(ip);
		if (inetAddress instanceof Inet4Address) {
			log.info("inetAddress 4 by ip '{}': {}", ip, inetAddress);
		}
		if (inetAddress instanceof Inet6Address) {
			log.info("inetAddress 6 by ip '{}': {}", ip, inetAddress);
		}
	}

}
