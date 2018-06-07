package controller;

import entity.Message;
import entity.Sujet;
import repository.CategorieRepository;
import repository.MessageRepository;
import repository.SujetRepository;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajout/sujet")
public class AjoutSujetController extends HttpServlet {

	private static final String VUES = "/accueil/";

		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String vue = VUES + "creer.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SujetRepository dao = new SujetRepository();
		CategorieRepository daoC = new CategorieRepository();
		MessageRepository daoM = new MessageRepository();
		
		Long categorie = Long.parseLong(req.getParameter("Idcategorie"));
		
		Sujet sujet = new Sujet();
		Message message = new Message();
		sujet.setDateCreation(new Date());
		sujet.setDateUpdate(new Date());
		sujet.setCategorie(daoC.getOne(categorie));
		sujet.setSujet(req.getParameter("sujet"));
		sujet.setId((new Long(dao.lectureSujet().size() + 1)));
		
		message.setSujet(sujet);
		message.setDateCreation(sujet.getDateCreation());
		message.setDateUpdate(sujet.getDateUpdate());
		message.setTexte(req.getParameter("message"));
		message.setId((new Long(daoM.lectureMessage().size() + 1)));

		dao.insertSujet(sujet);
		daoM.insertMessage(message);
		doGet(req, resp);
		}

}
