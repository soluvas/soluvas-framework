package org.soluvas.facebook;

import java.util.List;



/**
 * @author rudi
 *
 */
public class LikedObject {
	
	private Long id;
	private String created_time;
	private String name;
	private String category;
	private List<LikedCategory> category_list;
	
	public LikedObject() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<LikedCategory> getCategory_list() {
		return category_list;
	}

	public void setCategory_list(List<LikedCategory> category_list) {
		this.category_list = category_list;
	}

	@Override
	public String toString() {
		return "LikedObject [id=" + id + ", created_time=" + created_time
				+ ", name=" + name + ", category=" + category
				+ ", category_list=" + category_list + "]";
	}

}
