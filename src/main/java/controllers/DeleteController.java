package controllers;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film;


@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instantiation of FilmDAO instance and film object from FilmDAO and Film class
		FilmDAO dao = new FilmDAO();
		Film f = new Film();
		
		//requests id as a int value and sets the film objects id
		f.setId(Integer.valueOf(request.getParameter("id")));
	
		//using the deleteFilm method from the FilmDAO instance to delete the film in the db using the unique id.
		dao.deleteFilm(f.getId());
		
		//redirects the response to another resource and returns the portion of the request URI that indicates the context of the request
	    response.sendRedirect(request.getContextPath() + "/films");
	}

}
