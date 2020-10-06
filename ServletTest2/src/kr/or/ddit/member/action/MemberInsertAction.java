package kr.or.ddit.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.web.IAction;

public class MemberInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		 IMemberService memService = MemberServiceImpl.getInstance();
		
		 
		 String id = request.getParameter("mem_id");
		 String name = request.getParameter("mem_name");
		 String tel = request.getParameter("mem_tel");
		 String addr = request.getParameter("mem_addr");
		 
		 MemberVO memVo = new MemberVO();
		 memVo.setMem_id(id);
		 memVo.setMem_name(name);
		 memVo.setMem_tel(tel);
		 memVo.setMem_addr(addr);
		 
		 
		 memService.insertMember(memVo);
		 
		
	      
	      return "/member/memberList.do";
	}

}
