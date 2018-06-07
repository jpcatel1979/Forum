package controller;

import entity.Utilisateur;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import repository.UtilisateurRepository;

@WebServlet("/gestion/utilisateur")

public class GestionUtilisateurController extends HttpServlet {

	private static final String VUES = "/admin/";

		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilisateurRepository dao;
		dao = new UtilisateurRepository();
		String vue = VUES + "gestionUtilisateur.jsp";
		List<Utilisateur> lst = dao.lectureUtilisateur();
		req.setAttribute("lstUtilisateur", lst);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilisateurRepository dao;
		dao = new UtilisateurRepository();
		Utilisateur user = dao.getOne(req.getParameter("email"));
		dao.supprimerUtilisateur(user);
		doGet(req, resp);
		}

}
