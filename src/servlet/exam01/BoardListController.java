package servlet.exam01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;

@WebServlet(name="exam01.BoardListController",urlPatterns="/exam01/BoardListController")
public class BoardListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardListController service() 실행");
		List<Board> boards  = new ArrayList<>();
		for(int i=1; i<=10; i++){
			Board board = new Board();
			board.setBno(i);
			board.setBtitle("제목"+i);
			board.setBcontent("내용"+i);
			board.setBwriter("홍길동");
			board.setBdate(new Date());
			boards.add(board);
			
		}
		
		//결과를 jsp에서 사용할 수 있또록
		request.setAttribute("boards", boards);
		
		//jsp로 이동
		request.getRequestDispatcher("/WEB-INF/views/exam01/boardList.jsp").forward(request, response);
	}
	
	
}
