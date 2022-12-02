package servlet.exam13;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.Board;
import service.BoardService;

@MultipartConfig(maxFileSize = 1024*1024*10, maxRequestSize=1024*1024*20)
@WebServlet(name="exam13.WriteController", urlPatterns="/exam13/WriteController")
public class WriteController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/exam13/writeForm.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardService = (BoardService) request.getServletContext().getAttribute("boardService");
			
		//문자 파트
			Board board = new Board();
			board.setBtitle(request.getParameter("btitle"));
			board.setBcontent(request.getParameter("bcontent"));
			board.setBwriter(request.getParameter("bwriter"));
			
			//파일 파트
			Part filePart = request.getPart("battach");
			if(!filePart.getSubmittedFileName().equals("")) {
				String fileName = filePart.getSubmittedFileName();
				String savedName = new Date().getTime() + fileName;
				String fileType = filePart.getContentType();
				board.setBfileName(fileName);
				board.setBsavedName(savedName);
				board.setBfileType(fileType);
				
				String filePath = "C:/Temp/download/" + savedName;
				filePart.write(filePath);
				
			}
			
			boardService.wirte2(board);

		response.sendRedirect("ContentController");
	}
	


	

}
