package DAO.ServicesImp;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Com.Beans.Rdv;
import Util.HibernateUtil;

public class ServicesRdv {
	
	
	public void saveRdv(Rdv rdv) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			session.save(rdv);
			
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

	public Rdv getRdv(int id) {

		Transaction transaction = null;
		Rdv rdv = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an course object
			rdv = session.get(Rdv.class, id);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return rdv;
	}

	public ArrayList<Rdv> getAllRdvs() {

		ArrayList<Rdv> listRdvs = new ArrayList<Rdv>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		// start a transaction

		Query en = session.createQuery("FROM Rdv", Rdv.class);
		listRdvs = (ArrayList<Rdv>) en.getResultList();
		return listRdvs;
	}
	
	
	public ArrayList<Rdv> getAllRdvsByUser(int id) {
		ArrayList<Rdv> listRdvsByUser = new ArrayList<Rdv>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query1 = session.createQuery("from Rdv WHERE identifiant_user="+id);
		listRdvsByUser = (ArrayList<Rdv>) query1.list();
		return listRdvsByUser;
	}
	
	public void updateRdv(Rdv rdv) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			String hql = "UPDATE Rdv set isAccepted = true WHERE idRdv ="+rdv.getIdRdv();
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("modifié !!!!!!");

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
