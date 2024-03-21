package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/singer")
public class MK_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String singerList=req.getParameter("singerList");
		
		/*
		 name 속성값이 같은 파라미터가 여러개인 경우에는 
		 String[]로 한번에 반환 받는 
		 getParameterValues("name속성값") 사용하면 된다.
		 * */
		
		
		
		System.out.println(singerList);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/playList_Result.jsp");
		
		dispatcher.forward(req, resp);
	}
}
