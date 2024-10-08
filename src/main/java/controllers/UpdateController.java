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


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//requests id as an int value and sets the integer as the id
		int id = Integer.valueOf(request.getParameter("id"));
		
		//instantiation of FilmDAO instance from FilmDAO class
		FilmDAO dao = new FilmDAO();
		
		//using the getFilmByID method from the FilmDAO instance to get the specific film from the db using the unique id.
		Film f = dao.getFilmByID(id);
		
		//allows data to be added the request object that can be retrieved in the edit.jsp file.
		request.setAttribute("film", f);
		request.getRequestDispatcher("edit.jsp").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instantiation of FilmDAO instance and film object from FilmDAO and Film class
		FilmDAO dao = new FilmDAO();
		Film f = new Film();
		
		//requests parameters of the film object and sets the film objects
		f.setId(Integer.valueOf(request.getParameter("id")));
		f.setTitle(request.getParameter("title"));
		f.setDirector(request.getParameter("director"));
		f.setYear(Integer.valueOf(request.getParameter("year")));
		f.setStars(request.getParameter("stars"));
		f.setReview(request.getParameter("review"));

		//using the updateFilm method from the FilmDAO instance to update the film in the db using the parameters requested.
		dao.updateFilm(f);
		
		doGet(request, response);
		
		//redirects the response to another resource and returns the portion of the request URI that indicates the context of the request
	    response.sendRedirect(request.getContextPath() + "/films");
	}
}
