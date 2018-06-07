package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Categorie;
import entity.Utilisateur;
import repository.CategorieRepository;
import repository.UtilisateurRepository;

@WebServlet("/gestion/categorie/update")
public class ModifierCategorieController extends HttpServlet {

	private static final String VUES = "/categorie/";
	private String vue;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieRepository dao;
		dao = new CategorieRepository();
		vue = VUES + "modifier.jsp";
		req.setAttribute("cat", dao.getOne(new Long (req.getParameter("categorieId"))));
		req.setAttribute("lstCategorie", dao.lectureCategorie() );
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieRepository dao;
		dao = new CategorieRepository();
		Categorie catBDD = dao.getOne(new Long(req.getParameter("categorieId")));
		Categorie catUpdate = catBDD;
		vue = "/gestion/categorie";
		catUpdate.setDateUpdate(new Date());
		catUpdate.setTitre(req.getParameter("titre"));
		catUpdate.setCategorie(dao.getOne(new Long(req.getParameter("idCategorieMere"))));
		System.out.println(dao.getOne(new Long(req.getParameter("idCategorieMere"))));
		System.out.println(catUpdate);
		dao.modifierCategorie(catUpdate);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}	
}