package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

    private String fname;
    private String lname;
    private String contact;
    private String address;
    
    public User() {
    }

    public User(String fname, String lname, String contact, String address) {
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.address = address;
    }
    
	public User(int userId, String fname, String lname, String contact, String address) {
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.contact = contact;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", contact=" + contact
				+ ", address=" + address + "]";
	}

   

}
