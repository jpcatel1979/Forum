package controller;

import entity.Utilisateur;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.UtilisateurRepository;

@WebServlet(urlPatterns = { "/gestion/utilisateur/creation" })

public class CreationUtilisateurController extends HttpServlet {

	private static final String VUES = "/admin/";
	private String vue ="";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilisateurRepository dao;
		dao = new UtilisateurRepository();
		vue = VUES + "creerUtilisateur.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = new Utilisateur();
		Date today = new Date();
		Date birthday;
		UtilisateurRepository dao;
		dao = new UtilisateurRepository();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			birthday = formatter.parse(req.getParameter("birthday"));
			System.out.println(birthday);

		} catch (ParseException e) {
			birthday = new Date();
			e.printStackTrace();
		}

		switch (req.getParameter("role")) {
		case ("0"):
			user.setAdmin(false);
			break;
		case ("1"):
			user.setAdmin(true);
			break;
		}
		user.setEmail(req.getParameter("email"));
		user.setPseudo(req.getParameter("pseudo"));
		user.setPassword(Utilisateur.crypter(req.getParameter("mdp")));
		user.setDateCreation(today);
		user.setDateUpdate(today);
		user.setBirthday(birthday);
		user.setBan(false);

		dao.insertUtilisateur(user);
		
		
		vue = VUES + "gestionUtilisateur.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}
}
