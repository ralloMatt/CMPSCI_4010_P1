package project1.dataservlet.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//used to get page title information
import java.net.URL;
import java.util.*;

/**
 * Servlet implementation class URLservlet
 */
@WebServlet("/URLservlet")
public class URLservlet extends HttpServlet {
	//used for url information
	private static final long serialVersionUID = 1L;
  
	// using doPost method because form is "method=Post"
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response is of type html
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		int counter = 1;
		
		//get first URL entered by user
		String URL = request.getParameter("link" + counter);
		
		//create array of Titles
		List<String> myList = new ArrayList<String>();
		
		//Used for url information
		InputStream site = null;
		
		
		
		while(URL != null){ //keep searching until there is no URL left
			
			// try to open URL for each web page
			try {
				// open up URL
				site = new URL(URL).openStream();
				
				// scan in all the html code
				Scanner scanner = new Scanner(site);
				String page = scanner.useDelimiter("\\A").next();
				
				// add each title of web page in the array of titles
				// when adding to array, search for information between <title> and </title> in html code
				myList.add(page.substring
						(page.indexOf("<title>") + 7,
								page.indexOf("</title>")));
				
				scanner.close();
				
			// used for web page information	
			} catch (IOException ex) {
		        ex.printStackTrace();
			} finally {
		        try {
		            site.close();
		          
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }
			
			//adds to counter and then gets other URL if more than one
			counter++;
			// get the new URL if there is more
			URL = request.getParameter("link" + counter); 

		} // ends while

		
		// forward everything to the result page
		request.setAttribute("myList", myList);
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
		
		out.flush();
		out.close();
		
	}
}
