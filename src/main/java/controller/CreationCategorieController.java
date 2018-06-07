package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Categorie;
import repository.CategorieRepository;


@WebServlet("/gestion/categorie/creation")
public class CreationCategorieController extends HttpServlet {

	private static final String VUES = "/categorie/";
	private String vue;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieRepository dao;
		dao = new CategorieRepository();
		vue = VUES + "creer.jsp";
		req.setAttribute("lstCategorie", dao.lectureCategorie());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vue);
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieRepository dao = new CategorieRepository();
		Categorie mere = new Categorie ();
		Categorie categorie = new Categorie();
		if(req.getParameter("idCategorieMere") != "0"){
			mere = dao.getOne( new Long( req.getParameter("idCategorieMere")));
		}
		categorie.setId(new Long(dao.lectureCategorie().size() + 1));
		categorie.setTitre(req.getParameter("titre"));
		categorie.setDateCreation(new Date());
		categorie.setDateUpdate(new Date());
		categorie.setCategorie(mere);
		dao.insertCategorie(categorie);
		doGet(req,resp);
	}
}
