//Element Collection

package com.hibernate.entity.Company;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
 
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int cid;
	private String cname;
	
	@Cascade(CascadeType.ALL)
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "Addresstbl" ,joinColumns =@JoinColumn(name = "comp_id", referencedColumnName = "cid"))
	private List<CompanyAddress> address = new LinkedList<>();

	public List<CompanyAddress> getAddress() {
		return address;
	}

	public void setAddress(List<CompanyAddress> address) {
		this.address = address;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Company [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}

}
