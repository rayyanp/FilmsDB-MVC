package controllers;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//instantiation of FilmDAO instance from FilmDAO class
		FilmDAO dao = new FilmDAO();
		
		// Get the value of the "search" parameter from the request
		String search = request.getParameter("search");
		
		//using the getFilmByTitle method from the FilmDAO instance to get the list of Film objects from the dao object, 
		//using the value of the "search" parameter
		ArrayList<Film> filmsbyTitle = dao.getFilmByTitle(search);
		
		//allows data to be added the request object that can be retrieved in the films.jsp file.
		// Set the "film" attribute in the request to the list of Film objects
		request.setAttribute("films", filmsbyTitle);
		
		// Get a RequestDispatcher object for the "films.jsp" file
		RequestDispatcher rd = request.getRequestDispatcher("films.jsp");
		
		// Include the content of the "films.jsp" file in the response
		rd.include(request, response);

	}
	
	// This method is called when the servlet receives an HTTP POST request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Call the doGet method to handle the request
		doGet(request, response);
		
	}
}

