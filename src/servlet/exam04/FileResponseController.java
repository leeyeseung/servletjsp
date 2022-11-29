package servlet.exam04;

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

@WebServlet(name="exam04.FileResponseController", urlPatterns="/exam04/FileResponseController")
public class FileResponseController extends HttpServlet{


	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName="사진1.jpg";
		String filePath = "C:/Temp/photo1.jpg";
		String contentType = "image/jpg";
		
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
		
		System.out.println(fileName);
		
		
		//http 응답에 content - disposition 헤더를 추가~~~~~~~~
		response.setHeader("Content-disposition", "attachment; filename=\"" +fileName+"\"");
		
		ServletOutputStream sos = response.getOutputStream();
		
		
//		FileInputStream fis = new FileInputStream(filePath);
//		
//		byte[] data = new byte[1024];
//		while(true) {
//			int readByteNum = fis.read(data);
//			if(readByteNum == -1) break;
//			sos.write(data, 0, readByteNum);
//		}
//		sos.flush();
//		fis.close();
//		sos.close();
		
		Path path = Paths.get(filePath);
		Files.copy(path, sos);
		sos.flush();
		sos.close();

	}


}
