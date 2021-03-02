package DAO.ServicesImp;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Com.Beans.User;
import Util.HibernateUtil;

public class ServicesUser {

	public void saveUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

	public User validate(String userName, String password) {

		Transaction transaction = null;
		User user = null;

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		// start a transaction
		transaction = session1.beginTransaction();
		// get an user object
		user = (User) session1.createQuery("FROM User U WHERE U.userName = :userName")
				.setParameter("userName", userName).uniqueResult();

		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		// commit transactiono
		transaction.commit();

		if (transaction != null) {
			transaction.rollback();
		}

		return null;

	}

	public User getUser(int id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();

		User user = (User) session.get(User.class, id );

		transaction.commit();
		return user;
	}

	public ArrayList<User> getAllUsers() {
		Transaction transaction = null;
		ArrayList<User> listUser = new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		// start a transaction
		transaction = session.beginTransaction();
		Query en = session.createQuery("FROM User",User.class);
		listUser = (ArrayList<User>) en.getResultList();
		return listUser;
	}
	
	
}
