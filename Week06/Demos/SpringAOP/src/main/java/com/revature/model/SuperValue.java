package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * This will ignore any properties that are sent back which are not present in your
 * Java model.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class SuperValue {

	private int id;
	private String joke;
	
	public SuperValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuperValue(int id, String joke) {
		super();
		this.id = id;
		this.joke = joke;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJoke() {
		return joke;
	}
	public void setJoke(String joke) {
		this.joke = joke;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((joke == null) ? 0 : joke.hashCode());
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
		SuperValue other = (SuperValue) obj;
		if (id != other.id)
			return false;
		if (joke == null) {
			if (other.joke != null)
				return false;
		} else if (!joke.equals(other.joke))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuperValue [id=" + id + ", joke=" + joke + "]";
	}
	
}
