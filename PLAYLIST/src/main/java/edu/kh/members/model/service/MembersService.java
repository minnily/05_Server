package edu.kh.members.model.service;

import java.sql.Connection;

import edu.kh.members.model.dao.MembersDAO;
import edu.kh.members.model.dto.Members;
import static edu.kh.playlist.common.JDBCTemplate.*;

public class MembersService {

	
	private MembersDAO  dao = new MembersDAO(); 
	
	/** 로그인 서비스
	 * @param id
	 * @param pw
	 * @return loginMember
	 * @throws Exception
	 */
	public Members login(String id, String pw) throws Exception {
		
		Connection conn = getConnection();
		
		Members loginMember = dao.login(conn, id, pw);
		
		close(conn);
		
		return loginMember;
	}

	/** 회원가입 서비스
	 * @param members
	 * @return result
	 */
	public int signup(Members members) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.signup(conn,members);
		
		if(result>0) commit(conn);
		else		rollback(conn);
				
		
		return result;
	}

}
