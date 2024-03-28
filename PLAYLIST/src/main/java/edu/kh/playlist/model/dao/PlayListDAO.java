package edu.kh.playlist.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.playlist.model.dto.PlayList;

public class PlayListDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public PlayListDAO () {
		try {
			
		prop = new Properties();
		
		String filePath = PlayListDAO.class.getResource("/edu/kh/playlist/sql/playlist-sql.xml").getPath();
		
		prop.loadFromXML(new FileInputStream(filePath));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<PlayList> select(Connection conn, String playListNo, int no) throws Exception{
		
		List<PlayList> list = new ArrayList<PlayList>();
		
		try {
			
			String sql = prop.getProperty("select");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PlayList playList = new PlayList();
				
				playList.set( rs.getInt("TODO_NO"));
				playList.set( rs.getString("TODO_TITLE"));
				playList.set( rs.getString("TODO_MEMO"));
				playList.set( rs.getString("TODO_DATE"));
			
				list.add(playList);
			}
			
		} finally {
			
		}
		
		return list;
	}

}
