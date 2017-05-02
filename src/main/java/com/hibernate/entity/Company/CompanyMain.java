package com.hibernate.entity.Company;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.student.Student;

public class CompanyMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		Company company = new Company();
		company.setCname("IT Glance");
		Company company1 = new Company();
		company1.setCname("NCCSS");

		CompanyAddress companyaddress = new CompanyAddress();
		companyaddress.setCity("Kathmandu");
		companyaddress.setStreet("Chamati");
		company.getAddress().add(companyaddress);

		CompanyAddress companyaddress1 = new CompanyAddress();
		companyaddress1.setCity("Kathmandu");
		companyaddress1.setStreet("Paknajhol");
		company1.getAddress().add(companyaddress1);

		session.save(company);
		session.save(company1);
		session.getTransaction().commit();
		session.close();
	}

	public void update() {
		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * Company company = session.get(Company.class, 1); //
		 * System.out.println(company.toString()); if (company != null) {
		 * company.setCname("NCCS"); session.update(company); }
		 */
		Query qry = session.createQuery("update Company c set c.came=? where c.cid=1");
		qry.setParameter(0, "updated..");
		int res = qry.executeUpdate();

		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected due to update query" + res);

		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		// Company c = session.get(Company.class, 2);
		// c.getAddress();
		// session.delete(c);
		// session.delete(session.get(Company.class, 1));
		Query qry = session.createQuery("delete from Company c where c.cid=2");
		// qry.setParameter("java4s",110);
		int res = qry.executeUpdate();

		session.close();
	}

	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Company> companylist = session.createCriteria(Company.class).list();
		for (Company comp : companylist) {
			System.out.println(comp.getCname().toString());
			System.out.println(comp.getAddress().toString());

		}
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {

		CompanyMain c = new CompanyMain();
		// c.insert();
		c.update();
		//c.delete();
		// c.display();
	}
}
