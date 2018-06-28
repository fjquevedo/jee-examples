package es.data;

import java.util.List;

public class Parent {
	String id;
	String name;
	String description;
	List<Children> children;

	public Parent(String id, String name, String description, List<Children> children) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}

}
