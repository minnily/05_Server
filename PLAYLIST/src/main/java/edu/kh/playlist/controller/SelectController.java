package edu.kh.playlist.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.members.model.dto.Members;
import edu.kh.playlist.model.dto.PlayList;
import edu.kh.playlist.model.service.PlayListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/select")
public class SelectController extends HttpServlet{

	private PlayListService service = new PlayListService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			Members members = (Members)session.getAttribute("loginMember");
			
			List<PlayList> list = service.select(req.getParameter("playListNo"),members.getNo());
			
			req.setAttribute("playList", list);
			
			req.getRequestDispatcher("/WEB-INF/views/selsct.jsp").forward(req, resp);
 		} catch (Exception e) {
			System.out.println("노래목록 조회 중 예외 발생");
			e.printStackTrace();
		}
	}
}
