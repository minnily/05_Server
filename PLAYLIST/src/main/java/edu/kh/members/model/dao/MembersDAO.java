package edu.kh.members.model.dao;

import static edu.kh.playlist.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.members.model.dto.Members;

public class MembersDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MembersDAO() {
		
		try {
			prop = new Properties();
			
			String filePath = MembersDAO.class.getResource("/edu/kh/playlist/sql/members-sql.xml").getPath();
					
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/** 로그인 SQL실행하는 DAO
	 * @param conn
	 * @param id
	 * @param pw
	 * @return loginMember
	 * @throws Exception
	 */
	public Members login(Connection conn, String id, String pw) throws Exception{
		
		Members loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Members();
				loginMember.setNo(rs.getInt(1));
				loginMember.setId(rs.getString(2));
				loginMember.setNickName(rs.getString(3));
				loginMember.setEnrollDate(rs.getString(4));
				
			}
			
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return loginMember;
	}

	/** 회원가입 SQL실행하는 DAO
	 * @param conn
	 * @param members
	 * @return result
	 */
	public int signup(Connection conn, Members members) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signup");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, members.getId());
			pstmt.setString(2, members.getPw());
			pstmt.setString(3, members.getNickName());
			pstmt.setString(4, members.getGender());
			
			result =pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
