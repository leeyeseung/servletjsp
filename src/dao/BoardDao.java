package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import util.Pager;

public class BoardDao {
	
	public void insert(Board board, Connection conn)  {
		System.out.println("db에 board를 저장했습니다.");
		
	}
	
	public int insert2(Board board, Connection conn) throws Exception {
		String sql = "insert into boards2 (bno, btitle, bcontent, bwriter, bdate, bhit_count, bfile_name, bsaved_name, bfile_type)";
		sql += "values(seq_boards2_bno.nextval,?,?,?,sysdate,0,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		pstmt.setString(4, board.getBfileName());
		pstmt.setString(5, board.getBsavedName());
		pstmt.setString(6, board.getBfileType());
		int rows = pstmt.executeUpdate();
		pstmt.close();
		
		return rows;
		
	}

	public int countRows(Connection conn) throws Exception{
		String sql = "select count(*) from boards2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		rs.close();
		pstmt.close();
		return result;
	}

	public List<Board> selectPageList(Pager pager, Connection conn) throws Exception{
		String sql = "";
		sql += "select rnum, bno, btitle, bcontent, bwriter, bdate, bhit_count ";
		sql += "from( ";
		sql += "	select rownum as rnum, bno, btitle, bcontent, bwriter, bdate, bhit_count ";
		sql += "	from ( ";
		sql += "     	select bno, btitle, bcontent, bwriter, bdate, bhit_count ";
		sql += "	        from boards2 ";
		sql += "       		order by bno desc ";
		sql += "    ) where rownum <= ? ";
		sql +=") "; 
		sql +="where rnum >= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getPageNo()*pager.getRowsPerPage());
		pstmt.setInt(2, (pager.getPageNo()-1)*pager.getRowsPerPage() + 1);
		ResultSet rs = pstmt.executeQuery();
		List<Board> list = new ArrayList<>();
		while(rs.next()) {
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			board.setBhitCount(rs.getInt("bhit_count"));
			list.add(board);
		}
		rs.close();
		pstmt.close();
		return list;
	}

	public Board selectBoard(int bno, Connection conn) throws Exception{
		Board board = null;
		String sql = "select bno, btitle, bcontent, bwriter, bdate, bhit_count, bfile_name, bsaved_name, bfile_type ";
		sql += "from boards2 ";
		sql += "where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			board.setBhitCount(rs.getInt("bhit_count"));
			board.setBfileName(rs.getString("bfile_name"));
			board.setBsavedName(rs.getString("bsaved_name"));
			board.setBfileType(rs.getString("bfile_type"));
			
		}
		
		rs.close();
		pstmt.close();
		
		return board;
	}

}
