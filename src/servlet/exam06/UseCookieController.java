package servlet.exam06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam06.UseCookieController", urlPatterns="/exam06/UseCookieController")
public class UseCookieController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies(); //클라이언트가 보낸 쿠키들을 얻기
		for(Cookie cookie : cookies) {
			String name = cookie.getName(); //쿠키의 이름 읽기
			if(name.equals("useremail")) {
				//내가 원하는 쿠키라면 해당 쿠키 값을 읽어서 출력하기
				String value = cookie.getValue();
				System.out.println("useremail: "+value);
				//JSP에서 읽을 수 있도록 설정
				request.setAttribute("useremail", value);
				
			} else if(name.equals("userid")) {
				String value = cookie.getValue();
				System.out.println("userid: "+value);
				//JSP에서 읽을 수 있도록 설정
				request.setAttribute("userid", value);
			}
			
		}
		request.getRequestDispatcher("/WEB-INF/views/exam06/useCookie.jsp").forward(request, response);
	}
	


	

}
