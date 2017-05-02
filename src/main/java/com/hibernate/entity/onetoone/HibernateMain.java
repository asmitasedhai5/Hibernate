package com.hibernate.entity.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		Company company = new Company();
		company.setCname("Asmita Sedhai");
		
		Address address = new Address();
		address.setCity("Nepal");
		address.setStreet("Chiti");

		
		company.setAddress(address);
		session.save(company);
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {

		HibernateMain hm = new HibernateMain();
		hm.insert();

	}
}
