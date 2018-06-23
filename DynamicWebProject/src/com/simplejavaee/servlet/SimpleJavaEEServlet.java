package com.simplejavaee.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplejavaee.webaction.SearchNameWebAction;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(
        urlPatterns = "/SimpleJavaEEServlet",
        loadOnStartup = 1
)
public class SimpleJavaEEServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    //private static final String INDEX_PAGE = "index.jsp";
    private static final String VIEW_PAGE = "view.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleJavaEEServlet() {
        super();
    }

    public void init(ServletConfig config) {
        System.out.println("My servlet has been initialized");
    }

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(" ################################################################# : action : " + action);
		
		if ("searchName".equals(action)) {
			SearchNameWebAction doAction = new SearchNameWebAction();
			doAction.run(request, response);
		}
		
		response.sendRedirect(VIEW_PAGE);
	}

}
