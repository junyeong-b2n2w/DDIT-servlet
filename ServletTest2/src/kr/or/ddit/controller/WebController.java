package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.web.IAction;
import kr.or.ddit.web.URIActionMapper;

public class WebController extends HttpServlet {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

	   String uri = request.getRequestURI();
		
		uri = uri.substring(request.getContextPath().length());
		
		System.out.println("uri = " + uri);
		
		String viewPage = "";
		IAction action = null;
      
		action = URIActionMapper.getAction(uri);
		
		if(action == null){
			// 실행할 Action이 없으면 404에러 처리
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			// 실행 → 작업처리 후 View페이지를 받는다.
			viewPage = action.process(request, response);
			if(viewPage != null){
				if(action.isRedirect()){
					response.sendRedirect(request.getContextPath() + viewPage);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view" + viewPage);
					rd.forward(request, response);
				}
			}
		}
   }
   
}