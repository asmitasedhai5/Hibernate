package com.hibernate.entity.ManyToOneUnidirectional;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student student = new Student("Asmita", "Sedhai", "A");
		Student student1 = new Student("Alina", "Budhathoki", "A");
		Student student2 = new Student("Sita", "Thapa", "A");

		University university = new University("TU", "Nepal");
		University university1 = new University("KU", "Nepal");

		student.setUniversity(university);
		student1.setUniversity(university1);
		student2.setUniversity(university);

		session.save(student);
		session.save(student1);
		session.save(student2);

		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student student = session.get(Student.class, 1);
		session.delete(student);
		session.close();
		System.out.println("many to one delete done..!!");
		
	}

	@SuppressWarnings("unchecked")
	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		List<Student> studentlist = session.createCriteria(Student.class).list();
		//System.out.println(studentlist.toString());
		for(Student s:studentlist){
			System.out.println(s.getId()+" "+s.getFirstName()+" "+s.getLastName()+" "+s.getSection()+" "+s.getUniversity().getName());
		}
		@SuppressWarnings("deprecation")
		List<University> universitylist = session.createCriteria(University.class).list();
		//System.out.println(universitylist.toString());
		session.close();
	}

	public static void main(String[] args) {
		HibernateMain hm = new HibernateMain();
		// hm.insert();
		//hm.delete();
		hm.display();
	}

}
