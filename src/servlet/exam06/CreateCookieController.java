package servlet.exam06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam06.CreateCookieController", urlPatterns="/exam06/CreateCookieController")
public class CreateCookieController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("useremail","winter@mycompany.com");
		//cookie1.setDomain("localhost"); 해당 도메인으로 갈 때만 cookie 전달
		//cookie1.setPath("/"); //default로 /servletjsp/exam06/ 지금 뜻은 앞에 localhost만 맞으면 다 쿠키를 보내겠다
		//cookie1.setMaxAge(60);
		//cookie1.setHttpOnly(true);
		//cookie1.setSecure(true);
		//쿠키를 응답 헤더에 추가
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("userid","winter");
		response.addCookie(cookie2);
		
		response.sendRedirect("ContentController");
	}
	


	

}
