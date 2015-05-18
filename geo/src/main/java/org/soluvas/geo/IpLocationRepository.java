package org.soluvas.geo;

import java.util.Optional;

/**
 * 
 * Source: http://dev.maxmind.com/geoip/geoip2/geolite2/
 * 
 * @author rudi
 *
 */
public interface IpLocationRepository {
	
	/**
	 * Get country by ip 4 or 6 version
	 * 
	 * @param ip
	 * @return
	 */
	Optional<Country> getCountryByIp(String ip);

}
