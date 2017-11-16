package com.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.dao.UserDAO;
import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	

	SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void userInsert(User t) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> userView() {
        Session session = sf.openSession();
        session.beginTransaction();
        return session.createCriteria(User.class).list();
    }

	@Override
	public void userUpdate(User t) {
		System.out.println("User values for update:");
		System.out.println(t.toString());
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void userDelete(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		User user =(User) session.load(User.class, id);
		if(user != null){
			session.delete(user);
			session.getTransaction().commit();
		}
		session.close();
		
	}

	@Override
	public User userById(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		return (User) session.get(User.class, id);
	}

	



}
