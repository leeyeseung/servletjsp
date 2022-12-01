package servlet.exam07;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="exam07.GetSessionController", urlPatterns="/exam07/GetSessionController")
public class GetSessionController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session 객체 가져오기
		HttpSession session = request.getSession();
		
		//세션에 저장된 데이터(객체) 가져오기
		String loginId = (String) session.getAttribute("loginId");
		System.out.println("로그인 id: "+loginId);
		
		Date loginDate = (Date) session.getAttribute("loginDate");
		System.out.println("로그인 날짜: "+loginDate);
		
		List<String> cart = (List<String>) session.getAttribute("cart");
//		for(String productName : cart) {
//			System.out.println(productName);
//		}
		
		if(cart !=null) {
			for (int i=0; i<cart.size();i++) {
				System.out.println(i + ": "+cart.get(i));
			}
		}
		
		response.sendRedirect("ContentController");
	}
	


	

}
