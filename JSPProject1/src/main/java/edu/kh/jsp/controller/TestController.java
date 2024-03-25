package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test/result")
public class TestController extends HttpServlet{
	
	
	// a태그의 href 속성을 통해서 요청 받음-> GET요청
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 사용x, 값 세팅 x
		// 바로 JSP로 위임코드 작성
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/testResult.jsp");
	
		dispatcher.forward(req, resp);
	}

}
