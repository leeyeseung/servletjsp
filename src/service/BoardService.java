package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BoardDao;
import dto.Board;
import util.Pager;

public class BoardService {
private ServletContext application;
private DataSource ds;
private BoardDao boardDao;
	
	public BoardService(ServletContext application) {
		this.application = application;
		this.boardDao = (BoardDao) application.getAttribute("boardDao");
		//InitialContext ic = new InitialContext();
		ds = (DataSource) application.getAttribute("dataSource");
		
	}
	public void wirte(Board board) {
		System.out.println("게시물을 작성합니다.");
		
		boardDao.insert(board, null);
		
	}
	
	public void wirte2(Board board) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			boardDao.insert2(board, conn);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {};
		}
		
	}
	public int getTotalBoardNum() {
		Connection conn = null;
		int result = 0;
		try {
			conn = ds.getConnection();
			result = boardDao.countRows(conn);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {};
		}
		return result;
	}
	public List<Board> getPageList(Pager pager) {
		Connection conn = null;
		List<Board> result = null;
		try {
			conn = ds.getConnection();
			result = boardDao.selectPageList(pager, conn);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {};
		}
		return result;
	}
	public Board getBoard(int bno) {
		Connection conn = null;
		Board result = null;
		try {
			conn = ds.getConnection();
			result = boardDao.selectBoard(bno, conn);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch(Exception e) {};
		}
		return result;
	}

	

}
