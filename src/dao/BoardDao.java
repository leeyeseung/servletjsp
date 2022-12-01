package dao;

import java.sql.Connection;

import dto.Board;

public class BoardDao {
	
	public void insert(Board board, Connection conn) {
		System.out.println("DB에 Board 정보를 저장하였음");
	}

}
