package com.hibernate.entity.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateMain {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student student = new Student("Asmita", "Balaju");
		session.save(student);
		Student student1 = new Student("Alina", "Gongabu");
		session.save(student1);
		Student student2 = new Student("Saya", "Gudi");
		session.save(student2);
		session.getTransaction().commit();
		session.close();
	}

	public void update() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student student = session.get(Student.class, 1);
		System.out.println(student.toString());
		if (student != null) {
			student.setAddress("Manamaiju");
			student.setName("Asmeeta");
			session.update(student);
		}
		
		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student student = session.load(Student.class, 1);
		if (student != null) {

			session.delete(student);

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
	public void displayCriteria(){
		Session session = sf.openSession();
		session.beginTransaction();
		List<Student> studentList = session.createCriteria(Student.class).list();
		System.out.println(studentList.toString());
		session.close();
	}
	

	public static void main(String[] args) {

		HibernateMain hm = new HibernateMain();
		//hm.insert();
		hm.displayHql();

		// hm.update();
		// hm.delete();
	}

}
