package kr.or.ddit.basic.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class SessionLoginCheckServlet
 */
@WebServlet("/SessionLoginServlet.do")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";

		String userId = (String)session.getAttribute("memId");
		
		if(userId==null){
			viewPage = "/basic/03/sessionLogin.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String userId =request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";
		if(userId!=null && pass!=null){
			if(userId.equals("admin")&& pass.equals("1234")){
				session.setAttribute("memId", userId);
			}
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}

}
