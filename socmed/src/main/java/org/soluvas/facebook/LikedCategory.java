package org.soluvas.facebook;

/**
 * @author rudi
 *
 */
public class LikedCategory {
	
	private Long id;
	private String name;
	
	public LikedCategory() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LikedCategory [id=" + id + ", name=" + name + "]";
	}
	
}
