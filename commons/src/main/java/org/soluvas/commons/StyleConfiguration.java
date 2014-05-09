package org.soluvas.commons;




























































/**
 * Used by {@link org.soluvas.web.site.SiteResource} to get the current Mall's default style.
 * @author rio
 */
public interface StyleConfiguration {
	
	/**
	 * Default style name for Wicket, e.g. "fluid" (Cinta Lama's original theme, created by Ahmad Syarif Farsiado).
	 * @return
	 */
	public abstract String getDefaultStyle(); 

}
