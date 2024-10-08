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

@WebServlet("/films")
public class FilmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//instantiation of FilmDAO instance from FilmDAO class
		FilmDAO dao = new FilmDAO();
		
		//using the getAllFilms method from the FilmDAO instance to get all the films from the db as an array.
		ArrayList<Film> allfilms = dao.getAllFilms();
		
		//for each loop used to print out all the films in the console
		for (Film f: allfilms) {
			System.out.println(f.getTitle());
		}
		
		//allows data to be added the request object that can be retrieved in the films.jsp file.
		request.setAttribute("films", allfilms);
		RequestDispatcher rd = request.getRequestDispatcher("films.jsp");
		rd.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//instantiation of FilmDAO instance and film object from FilmDAO and Film class
		FilmDAO dao = new FilmDAO();
		Film f = new Film();

		//requests parameters of the film object and sets the film objects
		f.setTitle(request.getParameter("title"));
		f.setDirector(request.getParameter("director"));
		f.setYear(Integer.valueOf(request.getParameter("year")));
		f.setStars(request.getParameter("stars"));
		f.setReview(request.getParameter("review"));

		//using the updateFilm method from the FilmDAO instance to update the film in the db using the parameters requested.
		dao.insertFilm(f);
		doGet(request, response);

	}
}
