package edu.kh.playlist.model.service;

import static edu.kh.playlist.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.playlist.model.dao.PlayListDAO;
import edu.kh.playlist.model.dto.PlayList;


public class PlayListService {

	
	private PlayListDAO dao = new PlayListDAO();
	
	public List<PlayList> select(String playListNo, int no) throws Exception{
		
		Connection conn = getConnection();
		
		List<PlayList> list = dao.select(conn, playListNo, no);
		
		close(conn);
		
		return list;
	}

	

	
}
