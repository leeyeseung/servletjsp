package servlet.exam13;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import util.Pager;

@WebServlet(name="exam13.DetailViewController", urlPatterns="/exam13/DetailViewController")
public class DetailViewController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardService boardService = (BoardService) request.getServletContext().getAttribute("boardService");
		Board board = boardService.getBoard(bno);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/exam13/detailView.jsp").forward(request, response);
	}
	


	

}
