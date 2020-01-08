package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table
public class SuperOwner {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String homeLand;
	public SuperOwner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuperOwner(int id, String name, String homeLand) {
		super();
		this.id = id;
		this.name = name;
		this.homeLand = homeLand;
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
	public String getHomeLand() {
		return homeLand;
	}
	public void setHomeLand(String homeLand) {
		this.homeLand = homeLand;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((homeLand == null) ? 0 : homeLand.hashCode());
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
		SuperOwner other = (SuperOwner) obj;
		if (homeLand == null) {
			if (other.homeLand != null)
				return false;
		} else if (!homeLand.equals(other.homeLand))
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
		return "SuperOwner [id=" + id + ", name=" + name + ", homeLand=" + homeLand + "]";
	}
}
