package edu.kh.todoList.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.todoList.member.model.dto.Member;
import edu.kh.todoList.todo.model.dto.Todo;
import edu.kh.todoList.todo.model.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	private TodoService service = new TodoService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//session객체 생성하기
			HttpSession session = req.getSession();

			//Member에서 얻어올 값 적기
			Member member = (Member)session.getAttribute("loginMember");
			
			
			Todo todo = service.selectOne(req.getParameter("todoNo"),member.getMemberNo());
			
			req.setAttribute("todo", todo);
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		
			
		} catch (Exception e) {
			System.out.println("[수정할 Todo 조회 중 예외 발생]");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			Member member = (Member) session.getAttribute("loginMember");
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			String todoNo = req.getParameter("todoNo");
			
			int result = service.update(title, memo, member.getMemberNo(),todoNo);
			
			if(result > 0) {
				session.setAttribute("message", "수정되었습니다!");
				
				// todoList 갱신된 값으로 재등록
				List<Todo> todoList =service.selectAll(member.getMemberNo());
				session.setAttribute("todoList", todoList);
				
				// 메인페이지로 재요청
				resp.sendRedirect("/");
				
			}else {
				session.setAttribute("message", "수정실패!");
				
				resp.sendRedirect(req.getHeader("referer"));
			}
			
		} catch (Exception e) {
			System.out.println("[Todo 수정 중 예외 발생]");
			e.printStackTrace();
		}
	}
}
