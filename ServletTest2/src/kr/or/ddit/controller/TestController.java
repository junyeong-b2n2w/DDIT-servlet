package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class TestController extends HttpServlet{
	@Override
	public void init() throws ServletException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		//요청 URI => /member/memberList.do
		
		//1. 사용자의 요청 정보 가져오기
		String uri = req.getRequestURI();
		
		uri = uri.substring(req.getContextPath().length());
		
		System.out.println("uri = " + uri);
		
		String viewPage = "";
		
		if(uri == null){
			
		}else if("/member/memberList.do".equals(uri)){
			IMemberService memService = MemberServiceImpl.getInstance();
			List<MemberVO> memList = memService.getAllMember();
			
			req.setAttribute("memList",memList);
			viewPage = "/member/memberList.jsp";
			
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view" + viewPage);
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
		
		
	}
	
	@Override
	public void destroy() {

	}
	
	
}
