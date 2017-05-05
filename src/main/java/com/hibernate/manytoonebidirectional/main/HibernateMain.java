package com.hibernate.manytoonebidirectional.main;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.manytoonebidirectional.entity.Employee;
import com.hibernate.manytoonebidirectional.entity.Employer;

public class HibernateMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employer employer = new Employer();
		employer.setEmployerName("Employer 1");

		List<Employee> employees = new LinkedList<Employee>();

		Employee employee1 = new Employee();
		employee1.setEmployeeName("Ujjwal Pandey");
		employee1.setEmployer(employer);
		employees.add(employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeName("Utsav Thapa");
		employee2.setEmployer(employer);
		employees.add(employee2);

		employer.setEmployees(employees);

		session.save(employer);
		session.getTransaction().commit();
		session.close();
	}

	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings({ "deprecation", "unchecked" })

		List<Employee> employees = (List<Employee>) session.createQuery("from Employee ").list();
		for (Employee e : employees) {
			System.out
					.println("Employee Details : " + "Id:" + e.getId() + " " + "Employee name:" + e.getEmployeeName());
			System.out.println("Employer Details: " + "Employer Id:" + e.getEmployer().getId() + " " + "Employer name:"
					+ e.getEmployer().getEmployerName());
		}

		session.close();
	}

	public static void main(String[] args) {

		HibernateMain hm = new HibernateMain();
		hm.display();

	}
}
