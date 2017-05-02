package com.hibernate.entity.Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.entity.student.Student;

public class EmployeeMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = new Employee();
		employee.setName("Asmita Sedhai");
		
		Address address = new Address();
		address.setCountry("Nepal");
		address.setZone("Gandaki");
		address.setDistrict("Lamjung");
		address.setStreet("Chiti");

		Address address1 = new Address();
		address1.setCountry("Nepal");
		address1.setZone("Bagmati");
		address1.setDistrict("Kathmandu");
		address1.setStreet("Manamaiju");

		employee.setPermanentAddress(address);
		employee.setTemporaryAddress(address1);
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
			employee.setName("ASMEETA SEDHAI");
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
	
	
	public void displayHql(){
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student");
		List<Student> studentList = query.list();
		System.out.println(studentList.toString());
		session.close();
	}

	public static void main(String[] args) {

		EmployeeMain hm = new EmployeeMain();
		//hm.insert();
		hm.delete();

	}
}
