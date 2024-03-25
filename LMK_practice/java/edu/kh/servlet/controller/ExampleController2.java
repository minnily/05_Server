package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Servlet 관련 코드를 작성하기 위해서는 HttpServlet 클래스를 상속 받아야한다!


/*@Override
 △ 위와 같은 것들을 어노테이션이라고 한다!
 어노테이션?  컴파일러가 읽는 주석
 
@WebServlet 어노테이션?
해당 클래스를 Servlet으로 등록하고 매핑할 주소를 연결하라고 지시하는 어노테이션 
▷ 서버 실행 시 자동으로 web.xml에 <servlet><servlet-mapping>를 작성하는 효과이다.
 
 
 
 
 */


@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{

	// POST 요청 처리 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 원래 tomcat 버전때는 전달 받은 값을 얻어와서 확인하는 상황에서
		// 한글이 깨지는 문제가 발생했었음!
		// 따라서, 해결방법은? 전달 받은 데이터의 문자인코딩을 서버에 맞게 변경을 해줘야 함
		// 해결방법 ▷ req.setCharacterEncoding("UTF-8");
		// tomcat10 버전 이상부터는 자동으로 인코딩 처리를 해줌! 따라서 추가적인 처리가 필요없음! :) 
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		String intro = req.getParameter("intro");
		
		System.out.println(inputId);
		System.out.println(inputPw);
		System.out.println(inputName);
		System.out.println(intro);
		
		
		// 응답화면 만들기
		// 하지만...! 자바에서 작성하기 귀찮고 힘들다는 단점이 있음:(
		// ▶ 그래서 Servlet이 JSP에게 요청을 위임!
		//JSP ? Java Server Page (HTML 작성방식과 같은 방식임)
		
		// JSP가 화면을 대신 만들어주기 위해서 Servlet의 요청정보를 알아야함
		//▷ req에 있는 정보를 Dispatcher를 통해 알려줘야하며, jsp에게 요청 위임할 주소도 알려줘야함
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
								// △ webapp폴더 기준의 주소라고 생각하면 된다..!
		// △ webapp 폴더 하위의 views폴더 하위의 resul.jsp폴더에 위임을 하겠다는 의미!
		
		dispatcher.forward(req, resp);
	}
}
