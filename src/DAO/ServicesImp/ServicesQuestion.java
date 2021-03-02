package DAO.ServicesImp;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Com.Beans.Question;
import Com.Beans.Reponce;
import Com.Beans.User;
import Util.HibernateUtil;

public class ServicesQuestion {

	public void saveQuestion(Question question) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object

			session.save(question);
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

	public Question getQuestion(int id) {

		Transaction transaction = null;
		Question question = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an course object
			question = session.get(Question.class, id);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return question;
	}

	public ArrayList<Question> getAllQuestions() {
		Transaction transaction = null;
		ArrayList<Question> listQuestion = new ArrayList<Question>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		// start a transaction
		transaction = session.beginTransaction();
		Query en = session.createQuery("FROM Question", Question.class);
		listQuestion = (ArrayList<Question>) en.getResultList();
		return listQuestion;
	}

	public ArrayList<Question> getAllQuestionsByUser(int id) {
		Transaction transaction = null;
		ArrayList<Question> listQuestion = new ArrayList<Question>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query1 = session.createQuery("from Question Where identifiant = :id");
		query1.setParameter("id",id);

		listQuestion = (ArrayList<Question>) query1.list();
		return listQuestion;
	};
	

}
