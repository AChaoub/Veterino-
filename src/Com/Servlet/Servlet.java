package Com.Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ServicesImp.ServicesQuestion;
import DAO.ServicesImp.ServicesReponce;
import DAO.ServicesImp.ServicesUser;
import DAO.ServicesImp.ServicesRdv;
import Com.Beans.Question;
import Com.Beans.Rdv;
import Com.Beans.Reponce;
import Com.Beans.User;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesUser userDao;
	private ServicesQuestion questionDao;
	private ServicesReponce reponceDao;
	private ServicesRdv rdvDao;

	public void init() {
		userDao = new ServicesUser();
		questionDao = new ServicesQuestion();
		reponceDao = new ServicesReponce();
		rdvDao  = new ServicesRdv();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/Inscrip")) {

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUserName(username);
			user.setPassword(password);

			userDao.saveUser(user);

			request.getRequestDispatcher("Login_Veterino.jsp").forward(request, response);

		} else if (path.equals("/login")) {
			HttpSession session = request.getSession(true);
			String page = "Login_Veterino.jsp";

			try {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				User userConnecte = userDao.validate(username, password);
				
				if (userConnecte != null) {
					
					if (userConnecte.getRole().equals("Admin")) {
						System.out.println(userConnecte.getRole());
						int id = userDao.validate(username, password).getIdUser();
						session.setAttribute("Session_ADMIN", userDao.getUser(id));
						page = "Page_Veterinaire.jsp";
						DonnesAdminJsp(request, response);
					} else if (userConnecte.getRole().equals("Utilisateur")) {
						System.out.println(userConnecte.getRole());
						int id = userDao.validate(username, password).getIdUser();
						session.setAttribute("Session_USER", userDao.getUser(id));
						page = "Page_Client.jsp";
						DonnesClientJsp(request, response);
//						ArrayList<Question> questionClientConnecte = questionDao.getAllQuestionsByUser(id);
//						request.setAttribute("ListQuestionUserConnecte", questionClientConnecte);
						//DonnesClientJsp(request, response);
					}
					
					request.getRequestDispatcher(page).forward(request, response);
				} else if (userConnecte == null) {
					response.sendRedirect(page);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (path.equals("/repondreQuestion")) {
			//recuperer les champs textes du jsp
			int id_Question = Integer.parseInt(request.getParameter("idQuestion"));
			String reponce_Text = request.getParameter("Reponce");
			
			// recuperer L'utilisateur connecté de la session courante
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("Session_USER");
			User admin = (User) session.getAttribute("Session_ADMIN");
			Question questionR = questionDao.getQuestion(id_Question);
			
			
			if(user!=null) {
				User userConnecte = userDao.getUser(user.getIdUser());
				if(userConnecte.getRole().equals("Utilisateur")) {
					Reponce reponce = new Reponce(reponce_Text, questionR,user);
					reponceDao.saveReponce(reponce);
					DonnesClientJsp(request, response);
					request.getRequestDispatcher("Page_Client.jsp").forward(request, response);
					
				}
			}else if(admin!=null) {
				User adminConnecte = userDao.getUser(admin.getIdUser());
				if(adminConnecte.getRole().equals("Admin")){
					Reponce reponce = new Reponce(reponce_Text, questionR,admin);
					reponceDao.saveReponce(reponce);
					DonnesAdminJsp(request, response);
					request.getRequestDispatcher("Page_Veterinaire.jsp").forward(request, response);
				}
			}
			
		} else if (path.equals("/ajouterQuestion")) {

			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("Session_USER");

			// int id_User = user.getIdUser();
			String reponce_Text = request.getParameter("textQuestion");

			Question question = new Question(reponce_Text, user);
			questionDao.saveQuestion(question);
			DonnesClientJsp(request, response);
			request.getRequestDispatcher("Page_Client.jsp").forward(request, response);
		}
		else if (path.equals("/effectuerRdv")) {

			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("Session_USER");

			// int id_User = user.getIdUser();
			String motifRdv = request.getParameter("motifRdv");
			String dateRdv =request.getParameter("dateRdv") ;

			Rdv rdv = new Rdv(motifRdv,dateRdv, false, user);
			rdvDao.saveRdv(rdv);
			DonnesClientJsp(request, response);
			request.getRequestDispatcher("Page_Client.jsp").forward(request, response);
		}
		else if (path.equals("/confirmeRdv")) {

			int Rdv = Integer.parseInt(request.getParameter("Rdv"));

			Rdv rdvSelectionne = rdvDao.getRdv(Rdv);

			rdvDao.updateRdv(rdvSelectionne);
			DonnesAdminJsp(request, response);
			request.getRequestDispatcher("Page_Veterinaire.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		if (path.equals("/deconnecter")) {
			HttpSession session = request.getSession();
			session.removeAttribute("Session_USER");
			session.removeAttribute("Session_ADMIN");
			// request.getRequestDispatcher("/Accueil.jsp").forward(request, response);
			response.sendRedirect("Accueil.jsp");
		}
	}

	public void DonnesAdminJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Question> listQuestions = questionDao.getAllQuestions();
		ArrayList<Rdv>  listRdvs = rdvDao.getAllRdvs();
		request.setAttribute("listesQuestions", listQuestions);
		request.setAttribute("ListRdvs",listRdvs);
	}
	
	public void DonnesClientJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//recuperer l identifiant du Client
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("Session_USER");
		int id = user.getIdUser();
		
		ArrayList<Question> listQuestionParClient = questionDao.getAllQuestionsByUser(id);
		ArrayList<Rdv>  listRdvParClient = rdvDao.getAllRdvsByUser(id);
		request.setAttribute("ListQuestionUserConnecte", listQuestionParClient);
		request.setAttribute("ListRdvUserConnecte",listRdvParClient);
	}

	

}
