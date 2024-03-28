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

@WebServlet("/signup")
public class SignupController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//객체를 가지고 오기
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String nickName = req.getParameter("nickName");
			String gender = req.getParameter("gender");
			
			Members members =new Members();
			members.setId(id);
			members.setPw(pw);
			members.setNickName(nickName);
			members.setGender(gender);
		System.out.println(gender);
			
			MembersService service = new MembersService();
			
			System.out.println(members.toString());
			
			
			int result = service.signup(members);
			
			HttpSession session = req.getSession();
			
			if(result>0) {
				session.setAttribute("message", "회원가입이 완료되었습니다");
				resp.sendRedirect("/");
			}else {
				session.setAttribute("message", "회원가입에 실패했습니다\n 다시시도해주세요");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
			
		} catch (Exception e) {
			System.out.println("회원가입 중 예외 발생");
			e.printStackTrace();
		}
		
	}
}
