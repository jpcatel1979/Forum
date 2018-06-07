package controller;

import entity.Categorie;
import entity.Utilisateur;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.CategorieRepository;
import repository.UtilisateurRepository;

@WebServlet("/gestion/categorie")

public class GestionCategorieController extends HttpServlet {

	private static final String VUES = "/categorie/";

		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieRepository dao;
		dao = new CategorieRepository();
		String vue = VUES + "gestion.jsp";
		List<Categorie> lst = dao.lectureCategorie();
		req.setAttribute("lstCategorie", lst);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		}

}
