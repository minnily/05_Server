package gggg;

public class gggg {

	
	@WebServlet("/login")
	public class LoginController extends HttpServlet{

	private cs service = new cs();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
		
			String id = req.getParameter("id");
		
			String pw = req.getParameter("pw");
				
			c member = service.login(id, pw);
		
			req.setAttribute("member", member);
		
			req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req,resp);
		
			
			
			} catch (Exception e) {
		
			e.printStackTrace();
		
			}

	}

	}	
	
	
}
