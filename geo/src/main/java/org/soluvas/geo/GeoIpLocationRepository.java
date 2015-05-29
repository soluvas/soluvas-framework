package org.soluvas.geo;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Nullable;

import jline.internal.InputStreamReader;

import org.apache.commons.codec.binary.BinaryCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.opencsv.CSVReader;

/**
 * Source: http://dev.maxmind.com/geoip/geoip2/geolite2/
 * Please put '#' for the header
 * 
 * @author rudi
 *
 */
public class GeoIpLocationRepository implements IpLocationRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(GeoIpLocationRepository.class);
	
	private final ImmutableMap<String, GeoIpLocation> geoIp4LocationMap;
	private final ImmutableMap<String, GeoIpLocation> geoIp6LocationMap;

	public GeoIpLocationRepository(CountryRepository countryRepo) throws IOException {
		super();
		
		//loading for country location
		final ImmutableMap.Builder<String, GeoCountryLocation> geoCountryLocationMab = ImmutableMap.builder();
		try (final InputStreamReader reader = new InputStreamReader(GeoIpLocationRepository.class.getResourceAsStream("GeoLite2-Country-Locations-en.csv"))) {
			try (final CSVReader csv = new CSVReader(reader)) {
				while (true) {
					@Nullable String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					if (line[0].startsWith("#")) {
						continue;
					}
					final GeoCountryLocation geoCountryLocation = new GeoCountryLocation(line[0], line[4], line[5]);
					geoCountryLocationMab.put(line[0], geoCountryLocation);
				}
			}
		}
		final ImmutableMap<String, GeoCountryLocation> geoCountryLocationMap = geoCountryLocationMab.build();
		
		//loading for ip4
		final Builder<String, GeoIpLocation> geoIp4LocationMab = ImmutableMap.builder();
		try (final InputStreamReader reader = new InputStreamReader(GeoIpLocationRepository.class.getResourceAsStream("GeoLite2-Country-Blocks-IPv4.csv"))) {
			try (final CSVReader csv = new CSVReader(reader)) {
				while (true) {
					@Nullable String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					if (line[0].startsWith("#")) {
						continue;
					}
					if (Strings.isNullOrEmpty(line[1])) {
						continue;
					}
					final GeoCountryLocation geoCountryLocation = geoCountryLocationMap.get(line[1]);
					if (Strings.isNullOrEmpty(geoCountryLocation.getCountryIsoCode())) {
						continue;
					}
					final Country country = countryRepo.getCountry(geoCountryLocation.getCountryIsoCode());
					
					final String ipNetMask = line[0];
					
					final int constIp = new Integer(ipNetMask.substring(ipNetMask.indexOf("/") + 1, ipNetMask.length())).intValue();
					final String ipAdd = ipNetMask.substring(0, ipNetMask.indexOf("/"));
					final byte[] address = Inet4Address.getByName(ipAdd).getAddress();
					final String ipBinary = BinaryCodec.toAsciiString(new byte[] { address[3], address[2], address[1], address[0] });
					final String ipBinByConts = ipBinary.substring(0, constIp);
					
					final GeoIpLocation geoIpLocation = new GeoIpLocation(ipNetMask, line[1], country);
					geoIp4LocationMab.put(ipBinByConts, geoIpLocation);
				}
			}
		}
		geoIp4LocationMap = geoIp4LocationMab.build();
		
		//loading for ip6
		final Builder<String, GeoIpLocation> geoIp6LocationMab = ImmutableMap.builder();
//		try (final InputStreamReader reader = new InputStreamReader(GeoIpLocationRepository.class.getResourceAsStream("GeoLite2-Country-Blocks-IPv6.csv"))) {
//			try (final CSVReader csv = new CSVReader(reader)) {
//				while (true) {
//					@Nullable String[] line = csv.readNext();
//					if (line == null) {
//						break;
//					}
//					if (line[0].startsWith("#")) {
//						continue;
//					}
//					if (Strings.isNullOrEmpty(line[1])) {
//						continue;
//					}
//					final GeoCountryLocation geoCountryLocation = geoCountryLocationMap.get(line[1]);
//					if (Strings.isNullOrEmpty(geoCountryLocation.getCountryIsoCode())) {
//						continue;
//					}
//					final Country country = countryRepo.getCountry(geoCountryLocation.getCountryIsoCode());
//					final GeoIpLocation geoIpLocation = new GeoIpLocation(line[0], line[1], country);
//					geoIp6LocationMab.put(line[0], geoIpLocation);
//				}
//			}
//		}
		geoIp6LocationMap = geoIp6LocationMab.build();
		
	}

	/**
	 * @fixme FIXME: This searches ~168,000 entries for every method call!
	 * @see org.soluvas.geo.IpLocationRepository#getCountryByIp(java.lang.String)
	 */
	@Override
	public Optional<Country> getCountryByIp(final String ip) {
		try {
			final long startTime = System.currentTimeMillis();
			final InetAddress inetAddress = InetAddress.getByName(ip);
			@Nullable GeoIpLocation geoIpLocation = null;
			if (inetAddress instanceof Inet4Address) {
				final byte[] address = Inet4Address.getByName(ip).getAddress();
				final String ipBinary = BinaryCodec.toAsciiString(new byte[] { address[3], address[2], address[1], address[0] });
				
				for (int mask = 32; mask >=7 ; mask--) {
					geoIpLocation = geoIp4LocationMap.get(ipBinary.substring(0, mask));
				}
			}
			// Hendy's edit: ipv6 dataset not loaded?
//			if (inetAddress instanceof Inet6Address) {
//				final com.google.common.base.Optional<Entry<String, GeoIpLocation>> optGeoIpLocation = Iterables.tryFind(geoIp6LocationMap.entrySet(), new Predicate<Entry<String, GeoIpLocation>>() {
//					
//					@Override
//					public boolean apply(Entry<String, GeoIpLocation> input) {
//						final String ipRange = input.getKey();
//						final String ipStart = ipRange.substring(0, ipRange.indexOf("/") - 2);
//						
//						final String ipQuery = ip.substring(0, ip.lastIndexOf("::"));
//						
//						return ipStart.equals(ipQuery);
//					}
//				});
//				if (optGeoIpLocation.isPresent()) {
//					geoIpLocation = optGeoIpLocation.get().getValue();
//				}
//			}
			
			final long duration = System.currentTimeMillis() - startTime;
			if (geoIpLocation != null) {
				log.debug("IP {} is for country {} in {}ms", ip, geoIpLocation.getCountry(), duration);
				return Optional.of(geoIpLocation.getCountry());
			} else {
				log.debug("IP {} but unknown country in {}ms", ip, duration);
				return Optional.absent();  
			}
		} catch (UnknownHostException e) {
			log.error(String.format("Can not get inetAddress by ip '%s': %s", ip, e), e);
			return Optional.absent();
		}
	}

}
