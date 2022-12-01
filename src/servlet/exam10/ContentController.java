package servlet.exam10;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam10.ContentController", urlPatterns="/exam10/ContentController")
public class ContentController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.getRequestDispatcher("/WEB-INF/views/exam10/content.jsp").forward(request, response);
	}
	


	

}
