package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
// △jakarta ? 자바의 확장 같은 것들이 담겨있는 패키지!
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// Controller : 요청(Request)에 따라 어떤 Service를 호출할지 "제어"하고, 어떻게 응답(Response)을 할지 "제어"하는 역할
// ex ) 클라이언트 에서 요청을 보냄 ▷ 서버(Controller ▶ Service ▶ DAO ▶ DB ▷ DAO ▷ Service ▷ Controller)
public class ExampleController1 extends HttpServlet{
	
	
	//doGet() 메서드란?
	//▶ Get 방식 요청을 처리하는 메서드
	// 그래서 사용시에는 HttpServlet의 메서드를 오버라이딩하여 사용하면 된다~
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpServletRequest ?
		// 클라이언트 요청 시 생성되는 객체이다.
		// ▷ 이 안에는 클라이언트의 데이터 + 요청 관련 데이터가 들어있다.
		
		//HttpServletResponse
		// 클라이언트 요청시에 서버에서 생성하는 객체. 즉, 서버가 클라이언트에게 응답하기 위한 방법을 제공하는 객체이다.
		
		System.out.println("--- 이름, 나이를 입력받아 처리하는 코드 ---");
		
		// 요청 시 입력된 이름, 나이를 전달 받아오기
		
		//Parameter : 매개변수 , 그렇다면 매개변수란? 다른 곳의 값을 전달 받아올 때 사용하는 것을 말한다.
		// req.getParameter("name 속성값"); ?
		// ▷ 요청 시 전달된 데이터 중 name 속성값이 일치하는 데이터의 value를 얻어와 String 형태로 반환해주는 메서드이다.

		//HTML 에서 얻어오는 모든 값은 String!!!
		String name = req.getParameter("inputName");
		String age = req.getParameter("inputAge");
		
		System.out.println("입력 받은 이름 : "+name);
		System.out.println("입력 받은 나이 : "+age);
		
		// 서버 -> 클라이언트 응답하기
		// HttpServletResponse 객체 이용
		
		// 응답하는 문서의 형식과 문자인코딩을 지정
		resp.setContentType("text/html; charset=UTF-8");
		
		// 서버 -> 클라이언트로 연결되는 스트림 얻어오기
		// 서버에서 클라이언트로 응답하는 방법은 응답 페이지를 만들어서 보냄.
		PrintWriter out = resp.getWriter(); //서버 -> 클라이언트에게 쓰는것(출력)
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
			out.println("<title>서버 응답 결과</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h1>");
			out.println( name + "님의 나이는"+ age + "세 입니다");
			out.println("</h1>");
		
		out.println("</body>");
		
		out.println("</html>");
	
		
	}
	
	
}
