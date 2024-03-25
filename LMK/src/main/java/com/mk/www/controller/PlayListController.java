package com.mk.www.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/singer")
public class PlayListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String singerList=req.getParameter("singerList");
		
		
		System.out.println(singerList);
		
		
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/song/day6PlayList.jsp");
		
		dis.forward(req, resp);
	}
	
}
