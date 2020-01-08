package com.revature.model;

/*
 * Our model package will contain our model classes. These classes typically
 * match up with an entity in our database and are objects which are designed
 * to hold data. The fields are usually representative of the columns in
 * our entities. This class essentially models real-world data.
 */
public class SuperPet {

	private int id;
	private String name;
	private String color;
	private String power;
	private int age;
	private String owner;
	
	public SuperPet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuperPet(int id, String name, String color, String power, int age, String owner) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.power = power;
		this.age = age;
		this.owner = owner;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
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
		SuperPet other = (SuperPet) obj;
		if (age != other.age)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuperPet [id=" + id + ", name=" + name + ", color=" + color + ", power=" + power + ", age=" + age
				+ ", owner=" + owner + "]";
	}
	
}
