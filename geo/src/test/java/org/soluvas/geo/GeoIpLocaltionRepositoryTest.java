package org.soluvas.geo;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;

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
	
	@Test
	public void substringNetMaskIp4() throws UnknownHostException {
		final String ipRange = "192.168.1.2/24";
		
		final int constIp = new Integer(ipRange.substring(ipRange.indexOf("/") + 1, ipRange.length())).intValue();
		log.info("constIp: {}", constIp);
		final String ipAdd = ipRange.substring(0, ipRange.indexOf("/"));
		log.info("ipAdd: {}", ipAdd);
		final List<String> ipSplit = Splitter.on('.').splitToList(ipAdd);
		
//		final String ipBinary = BinaryCodec.toAsciiString(Byte.paripSplit.get(0).getBytes()) + "." + BinaryCodec.toAsciiString(ipSplit.get(1).getBytes()) + "." +
//				BinaryCodec.toAsciiString(ipSplit.get(2).getBytes()) + "." + BinaryCodec.toAsciiString(ipSplit.get(3).getBytes());
		final byte[] address = Inet4Address.getByName(ipAdd).getAddress();
		final String ipBinary = BinaryCodec.toAsciiString(new byte[] { address[3], address[2], address[1], address[0] });
		log.info("ipBinary: {}", ipBinary);
		final String ipBinByConts = ipBinary.substring(0, constIp);
		log.info("ipBin: {}", ipBinByConts);
		
		log.info("==============");
		final String ip = "192.168.1.5";
		final byte[] byteAddress = Inet4Address.getByName(ip).getAddress();
		final String strIpBinary = BinaryCodec.toAsciiString(new byte[] { byteAddress[3], byteAddress[2], byteAddress[1], byteAddress[0] });
		log.info("strIpBinary: {}", strIpBinary);
	}
	
	@Test
	public void substringNetMaskIp6() throws UnknownHostException {
		final String ipRange = "2001:200::/49";
		
		final int constIp = new Integer(ipRange.substring(ipRange.indexOf("/") + 1, ipRange.length())).intValue();
		log.info("constIp: {}", constIp);
		final String ipAdd = ipRange.substring(0, ipRange.indexOf("/"));
		log.info("ipAdd: {}", ipAdd);
//		final List<String> ipSplit = Splitter.on(':').splitToList(ipAdd);
		
//		final String ipBinary = BinaryCodec.toAsciiString(Byte.paripSplit.get(0).getBytes()) + "." + BinaryCodec.toAsciiString(ipSplit.get(1).getBytes()) + "." +
//				BinaryCodec.toAsciiString(ipSplit.get(2).getBytes()) + "." + BinaryCodec.toAsciiString(ipSplit.get(3).getBytes());
		final byte[] address = Inet6Address.getByName(ipAdd).getAddress();
		final String ipBinary = BinaryCodec.toAsciiString(new byte[] { address[3], address[2], address[1], address[0] });
		log.info("ipBinary: {}", ipBinary);
		final String ipBinByConts = ipBinary.substring(0, constIp);
		log.info("ipBin: {}", ipBinByConts);
		
	}

}
