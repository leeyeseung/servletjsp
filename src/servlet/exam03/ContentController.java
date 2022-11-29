package servlet.exam03;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContentController extends HttpServlet{
	private String encoding;
	private String viewLocation;
	
	//클라이언트에서 최초로 서블릿을 요청했을 때 한 번 실행(load-on-startup 옵션이 없을 경우)
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("exam03.ContentController.init()");
		
		encoding= "UTF-8";
		viewLocation = "/WEB-INF/views";
		
		if(config.getInitParameter("encoding")==null) {
			encoding= "UTF-8";
		} else {
			encoding = config.getInitParameter("encoding");
		}
		
		if(config.getInitParameter("viewLocation")==null) {
			viewLocation = "/WEB-INF/views";
		} else {
			viewLocation = config.getInitParameter("viewLocation");
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doGet()");
		request.getRequestDispatcher(viewLocation+"/exam03/content.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doPost()");
		
		request.setCharacterEncoding(encoding);
		String param1 = request.getParameter("param1");
		System.out.println("param1: "+param1);
		
		request.getRequestDispatcher(viewLocation+ "/exam03/content.jsp").forward(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("exam03.ContentController.destroy()");
	}
	
	

}
