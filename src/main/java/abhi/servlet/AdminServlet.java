package abhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abhi.game.FindAlphabets;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	private static Long count = 0L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().setAttribute("pageHits", ++count);
		Boolean formSubmitted = (Boolean) request.getAttribute("formSubmission");
		RequestDispatcher dispatcher = null;
		if (formSubmitted != null && formSubmitted) {
			ServletContext context = getServletContext();
			String letter = request.getParameter("letter");
			String[] letters = letter.split(",");
			String category = request.getParameter("category");
			String[] refinements = request.getParameterValues("refinement");
			FindAlphabets findAlphabets = new FindAlphabets();
			// List<String> words =
			// findAlphabets.findStartsWithAlphabets(letter, category);
			List<String> words = findAlphabets.findStartsWithAlphabets(letters, refinements, category);
			request.setAttribute("words", words);
			dispatcher = context.getRequestDispatcher("/games/letterFinder/letterFinder.jsp");
			// RequestDispatcher dispatcher =
			// context.getRequestDispatcher("/base/games/letterFinder/letterFinder.jsp");
			dispatcher.forward(request, response);
		} else {

			response.sendRedirect(request.getContextPath() + "/games/letterFinder/letterFinder.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("formSubmission", true);
		doGet(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response){
		
	}

}
