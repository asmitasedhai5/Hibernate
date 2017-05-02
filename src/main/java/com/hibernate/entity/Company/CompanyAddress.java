package com.hibernate.entity.Company;

import javax.persistence.Embeddable;


@Embeddable


public class CompanyAddress {
 	private String city;
	private String street;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "CompanyAddress [city=" + city + ", street=" + street + "]";
	}
	

}
