package controller;

import entity.Categorie;
import entity.Message;
import entity.Sujet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.CategorieRepository;
import repository.MessageRepository;
import repository.SujetRepository;

@WebServlet("/accueil")
public class AccueilController extends HttpServlet {

	private static final String VUES = "/accueil/";

		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieRepository dao;
		SujetRepository daoS;
		MessageRepository daoM;
		
		dao = new CategorieRepository();
		daoS = new SujetRepository();
		daoM = new MessageRepository();
		
		String vue = VUES + "index.jsp";
		List<Categorie> lstC = dao.lectureCategorie();
		List<Sujet> lstS = daoS.lectureSujet();
		List<Message> lstM = daoM.lectureMessage();
		
		req.setAttribute("lstCategorie", lstC);
		req.setAttribute("lstSujet", lstS);
		req.setAttribute("lstMessage", lstM);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		}

}
