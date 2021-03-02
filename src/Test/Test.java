package Test;

//import org.hibernate.Session;

import Com.Beans.User;

import java.util.ArrayList;

import Com.Beans.Question;
import Com.Beans.Reponce;
import DAO.ServicesImp.*;


//import Util.HibernateUtil;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServicesUser UserDao = new ServicesUser();
		ServicesQuestion QuestionDao =  new ServicesQuestion();
		ServicesReponce ReponceDao = new ServicesReponce();


		
//		User u1 = new User("GHIYATI", "ABDO", "AGHIYATI", "1234");		
//		UserDao.saveUser(u1); 
		
//		Question question1 = new Question("Est ce vous ouvrerez le samedi?",UserDao.getUser(2));
//		QuestionDao.saveQuestion(question1);
//		
//		
//		Reponce reponce1 = new Reponce("Effectivement Cher Client <3", QuestionDao.getQuestion(6));
//		ReponceDao.saveReponce(reponce1);
//		Reponce reponce2 = new Reponce("500DHS pour les Chevaux/Vaches.....", QuestionDao.getQuestion(1));
//		ReponceDao.saveReponce(reponce2);
//		Reponce reponce3 = new Reponce("1500DHS pour les animaux sauvages", QuestionDao.getQuestion(1));
//		ReponceDao.saveReponce(reponce3);
//		
		
//		ArrayList<Reponce> listReponces = ReponceDao.getAllReponces();
//		
//		for(Reponce rep :listReponces) {
//			System.out.println(rep.toString());
//		}
//		
		
		ArrayList<Question> lis = QuestionDao.getAllQuestionsByUser(2);
//		ArrayList<Reponce> reps = ReponceDao.getAllReponcesByQuestion(1);
//		
		int i =0;
		for(Question qst :lis) {
			i++;
			System.out.println("Question de MR :"+qst.getUser().getLastName().toString() + "\n \t question "+i+": "+qst.getDescriptionQuestions());	
		}
//		int id = 1;
//		ArrayList<Reponce> reps = ReponceDao.getAllReponcesByQuestion(id);
//			for(Reponce rep : reps) {
//				System.out.println("Reponces du question "+id+" :"+rep.getDescriptionReponse());
//				//System.out.println(rep.getQuestion().getUser().getFirstName()+ " " +rep.getQuestion().getUser().getFirstName().toString());
//			}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Question question = QuestionDao.getQuestion(1);
//		System.out.println(question.toString());

//		Question question1 = new Question("Question une ZT_YC?",UserDao.getUser(1));
//		QuestionDao.saveQuestion(question1);
		
//		ArrayList<Question>  listeQuestions = QuestionDao.getAllQuestionsByUser(1);
//		
//		for(Question question :listeQuestions) {
//			System.out.println(question.toString());
//		}
//		
//		User u1 = new User("CHAOUB", "ACHRAF", "ACHAOUB", "1234");		
//		UserDao.saveUser(u1);
		//User user = new User("kgh","jhlk", "hkjh", "jhgjb");
		

		
//		Question question1 = new Question("Question une ZT?",UserDao.getUser(1));
//		QuestionDao.saveQuestion(question1);
		
//		Question question1 = new Question("Question une ZT_ALL?",UserDao.getUser(1));
//		QuestionDao.saveQuestion(question1);
		
		
		
//		
		
		//User user = UserDao.getUser(1);
		//System.out.println(user.toString());
		
		
//		QuestionDao.saveQuestion(question1);
		//Question question1 = QuestionDao.getQuestion(14);
		//u1.addQuestion(question1);
		//System.out.println(question1.toString());
//		
//		
		//User u1 = UserDao.getUser(2);
		//System.out.println(u1.toString());
		//User user = (User) UserDao.getUser(1);
		//Question question1 = new Question("Question une?",user);
		//QuestionDao.saveQuestion(question1);
		//u1.addQuestion(question1);
		
		
		
		//Question question1 = QuestionDao.getQuestion(1);
		//Question question2 = QuestionDao.getQuestion(1);
		//u1.addQuestion(question1);
		//u1.addQuestion(question2);

		
		//System.out.println(u1.toString());
		

		// ServicesUser AjouterUser = new ServicesUser();
		// ServicesQuestion ServicesQ = new ServicesQuestion();

		// User u = new User("Ghiyati", "Abdo", "Ghiyyyy", "1234");
		// User u1 = new User("Ach", "Miyy", "Ach", "1234");
		// Question q1 = new Question("Ghiyati_Basha", u);
		// Question q2 = new Question("Ghiyati_Basha2", u1);

		// System.out.println(q2);

		// AjouterUser.saveUser(u1);

		// System.out.println(AjouterUser.getAllUsers().get(1).getLastName());

		// AjouterUser.testRole(u);

		// System.out.println(AjouterUser.validate("ACHAOUB","1234").toString());
		// System.out.println(AjouterUser.getUser(1).getUserName());

		// u1.toString();

		
		//User user1 = new User("Abdo","Giyati", "Gigio", "123");
		

		// create some courses
		//Question question1 = new Question("Learn Spring Boot?");
		//user1.getQuestions().add(question1);
		
		//Question question2 = new Question("Learn hibernate");
		//user1.getQuestions().add(question2 );

		//UserDao.saveUser(user1);
		
		
		//ArrayList<User> users =UserDao.getAllUsers();
		
		
		
//		for(User u :users) {
//			System.out.println(u.toString());
//		}
		
		
		
		

	}

}
