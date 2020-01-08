package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * This annotation specifies that this class is an entity. This means that
 * Hibernate will map this class as an entity for us, creating an entity
 * within our DB if one exist or matching to an existing entity.
 */
@Entity

/*
 * This denotes that this JavaBean has a table representation in our DB.
 */
@Table(name="SuperPetTable")
public class SuperPet {

	/*
	 * This denotes that this property serves as a primary key.
	 */
	@Id
	/*
	 * This annotation specifies what the generation strategy is for
	 * our primary key. In this case, we have chosen "Auto," which means
	 * that Hibernate will automatically select the most appropriate
	 * generation strategy for us.
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	/*
	 * This annotation denotes that this should be a column on our table.
	 */
	@Column(name="SuperPetPK")
	private int id;
	@Column
	private String name;
	@Column
	private String color;
	@Column
	private String power;
	@Column
	private int age;
	
	/*
	 * In Hibernate, we can fetch associations quite easily. We only need
	 * add our associations as fields on our model so that Hibernate can
	 * fetch them with the record itself. Hibernate essentially performs
	 * a join for you.
	 * 
	 * This ManyToOne annoation specifies that there should be a many to one
	 * relationship between this entity and the SuperOwner.
	 * 
	 * It is also worth noting that Hibernate will only EAGERLY FETCH associations
	 * if the association is NOT a collection. If the association is a collection,
	 * then Hibernate will use LAZY LOADING instead.
	 * 
	 * When Hibernate lazily loads entites, it creates "proxies." These
	 * proxies temporarily take the place of the actual data that will be
	 * loaded later. Note that Hibernate creates these proxies by creating
	 * a subclass of the model and replacing what would have been an instance
	 * of your model with its subclass, which contains null fields -- except
	 * for the identifier (primary key). For this reason, Hibernate models
	 * can't be final classes.
	 */
	@ManyToOne
	@JoinColumn
	private SuperOwner superOwner;
	
	public SuperPet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SuperPet(int id, String name, String color, String power, int age, SuperOwner superOwner) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.power = power;
		this.age = age;
		this.superOwner = superOwner;
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
	
	public SuperOwner getSuperOwner() {
		return superOwner;
	}

	public void setSuperOwner(SuperOwner superOwner) {
		this.superOwner = superOwner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
				+ ", superOwner=" + superOwner + "]";
	}
}
