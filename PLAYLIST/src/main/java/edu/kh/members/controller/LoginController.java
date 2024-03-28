package edu.kh.members.controller;

import java.io.IOException;

import edu.kh.members.model.dto.Members;
import edu.kh.members.model.service.MembersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try{
			String id = req.getParameter("id");
		
			String pw = req.getParameter("pw");
			
			MembersService service = new MembersService();
			
			Members loginMember = service.login(id,pw);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) {
					
				session.setAttribute("loginMember", loginMember);
				
				session.setMaxInactiveInterval(60*60);
					
				//---------------------------------
				//로그인이 되었을 때 나타날 페이지 
				
				resp.sendRedirect("/");
					
			}else {
					
					session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
					
					String referer=req.getHeader("referer");
					
					resp.sendRedirect(referer);
				}
			
			}catch (Exception e) {
				System.out.println("로그인 중 예외가 발생했습니다");
				e.printStackTrace();
			}
	}
}
