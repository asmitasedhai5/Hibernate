//Attribute Override----value object---aggregation

package com.hibernate.entity.Employee;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name = "country", column = @Column(name = "p_country")),
	@AttributeOverride(name = "zone", column = @Column(name = "p_zone")),
	@AttributeOverride(name = "district", column = @Column(name = "p_district")),
	@AttributeOverride(name = "street", column = @Column(name = "p_street")),

	})
	private Address permanentAddress;
	@Embedded
	private Address temporaryAddress;
	

	
	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Address getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(Address temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
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

}
