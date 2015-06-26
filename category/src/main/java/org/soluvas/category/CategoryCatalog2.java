package org.soluvas.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rudi
 *
 */
public class CategoryCatalog2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final List<FormalCategory> formalCategories = new ArrayList<>();;

	public List<FormalCategory> getFormalCategories() {
		return formalCategories;
	}

}
