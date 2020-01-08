package com.revature.designpatterns;

import java.io.Serializable;

/*
 * A Java Bean is a class that follows a very particular design pattern. A 
 * Java Bean must implement Serializable (which I'll never do), have a no-args
 * constructor, a constructor with fields, getters, setters, override toString,
 * hashCode, and equals.
 */
public class JavaBean implements Serializable{

	private int id;
	private String name;
	private int anotherId;
	
	public JavaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JavaBean(int id, String name, int anotherId) {
		super();
		this.id = id;
		this.name = name;
		this.anotherId = anotherId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAnotherId() {
		return anotherId;
	}
	public void setAnotherId(int anotherId) {
		this.anotherId = anotherId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anotherId;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaBean other = (JavaBean) obj;
		if (anotherId != other.anotherId)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JavaBean [id=" + id + ", name=" + name + ", anotherId=" + anotherId + "]";
	}
	
}
