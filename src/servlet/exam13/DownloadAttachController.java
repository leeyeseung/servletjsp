package servlet.exam13;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;

@WebServlet(name="exam13.DownloadAttachController", urlPatterns="/exam13/DownloadAttachController")
public class DownloadAttachController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardService boardService = (BoardService) request.getServletContext().getAttribute("boardService");
		Board board = boardService.getBoard(bno);
		
		String fileName= board.getBfileName();
		String filePath = "C:/Temp/download/" + board.getBsavedName();
		String contentType = board.getBfileType();
		
		//http 응답에 content - type 헤더를 추가ㅏ!!!!!!!!!!!!!
		response.setContentType(contentType);
		
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Trident")||userAgent.contains("MSIE")) {
			//이면 인터넷 익스플로러인 경우를 이야기함 ㄴ
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			//크롬, 엣지, 파이어폭스, 사파리 
			fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
		
		//http 응답에 content - disposition 헤더를 추가~~~~~~~~
		//response.setHeader("Content-disposition", "attachment; filename=\"" +fileName+"\"");
		
		ServletOutputStream sos = response.getOutputStream();
		Path path = Paths.get(filePath);
		Files.copy(path, sos);
		sos.flush();
		sos.close();
	}
	


	

}
