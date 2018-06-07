package controller;

import entity.Message;
import entity.Sujet;
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

@WebServlet("/ajout/message")
public class AjoutMessageController extends HttpServlet {

	private static final String VUES = "/accueil/";

		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String vue = VUES + "message.jsp";
		String sujet = req.getParameter("Idsujet");
		req.setAttribute("sujet", sujet);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SujetRepository dao = new SujetRepository();
		MessageRepository daoM = new MessageRepository();
		Sujet sujet = new Sujet();		
		Message message = new Message();
		sujet = dao.getOne(new Long(req.getParameter("idSujet")));
		
		
		message.setSujet(sujet);
		message.setDateCreation(new Date());
		message.setDateUpdate(new Date());
		message.setTexte(req.getParameter("message"));
		message.setId((new Long(daoM.lectureMessage().size() + 1)));

		daoM.insertMessage(message);
		doGet(req, resp);
		}

}
