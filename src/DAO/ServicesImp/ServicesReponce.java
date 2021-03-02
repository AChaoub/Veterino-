package DAO.ServicesImp;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Com.Beans.Question;
import Com.Beans.Reponce;
import Util.HibernateUtil;

public class ServicesReponce {
	
	
	public void saveReponce(Reponce reponce) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object

			session.save(reponce);
			// commit transaction
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Reponce getReponce(int id) {

		Transaction transaction = null;
		Reponce reponce = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an course object
			reponce = session.get(Reponce.class, id);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return reponce;
	}

	public ArrayList<Reponce> getAllReponces() {
		//Transaction transaction = null;
		ArrayList<Reponce> listReponces = new ArrayList<Reponce>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		// start a transaction
		//Transaction transaction = session.beginTransaction();
		Query en = session.createQuery("FROM Reponce", Reponce.class);
		listReponces = (ArrayList<Reponce>) en.getResultList();
		return listReponces;
	}
	
	
	public ArrayList<Reponce> getAllReponcesByQuestion(int id) {
		Transaction transaction = null;
		ArrayList<Reponce> listReponces = new ArrayList<Reponce>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query1 = session.createQuery("from Reponce Where identifiant_question ="+id);
		//query1.setParameter(1, id);
		
		listReponces = (ArrayList<Reponce>) query1.list();
		return listReponces;
	};

}
