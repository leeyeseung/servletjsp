package servlet.exam05;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam05.HttpHeaderInfoController", urlPatterns="/exam05/HttpHeaderInfoController")
public class HttpHeaderInfoController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시작행 정보 얻기 요청방식 얻기
		String method = request.getMethod();
		System.out.println("요청방식: "+method);
		
		//전체 경로
		String requestURL = request.getRequestURL().toString();
		System.out.println("requestURL"+requestURL);
		
		String requestURI = request.getRequestURI();
		System.out.println("요청경로: "+requestURI);
		
		//contextPath만 얻기
		String contextPath = request.getContextPath();
		System.out.println("ContextPath: "+contextPath);
		
		String queryString = request.getQueryString();
		System.out.println("QueryString: "+queryString);
		
		//헤더행 정보 얻기
		String userAgent = request.getHeader("User-Agent");
		System.out.println("User-Agent: "+userAgent);
		
		//클라이언트의 IP정보 얻기 
		String remoteAddr = request.getRemoteAddr();
		System.out.println("Remote Addr: "+remoteAddr);
		
		response.sendRedirect("ContentController");
		
	}
	


	

}
