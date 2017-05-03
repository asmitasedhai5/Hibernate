package com.hibernate.manytoonebidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.manytoonebidirectional.entity.Employee;

public class HibernateMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = new Employee();
		employee.setEmployeeName("Asmita Sedhai");
		
		
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	public void update() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee.toString());
		if (employee != null) 
			employee.setEmployeeName("ASMEETA SEDHAI");
			session.update(employee);
		
		
		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, 1);
		if (employee != null) {

			session.delete(employee);

		}
		// session.getTransaction().commit();
		session.close();
	}
	public void display(){
		
	}
	
	

	public static void main(String[] args) {

		HibernateMain hm = new HibernateMain();
		//hm.insert();
		//hm.delete();
		hm.display();

	}
}

