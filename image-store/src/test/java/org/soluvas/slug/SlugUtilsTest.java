package org.soluvas.slug;

import junit.framework.Assert;

import org.junit.Test;

public class SlugUtilsTest {

	@Test
	public void resourceId() {
		Assert.assertEquals("aku_gak_punya_pulsaaaaa", SlugUtils.generateId("aku gak punya pulsaaaaa", 0));
	}

}
