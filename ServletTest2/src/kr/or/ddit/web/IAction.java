package kr.or.ddit.web;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

public interface IAction {
   //IAction을 Implements한 클래스에서 View(jsp)를 결정하고 
   //해당 View로 Redirect할 것인지 forward를 할 것인지 결정하는 메서드
   public boolean isRedirect();

   // IAction을 implements한 클래스의 process()메서드를 호출해서 URI를 기준으로 한 요청 처리를 위임하고 View페이지를 반환하는 메서드
   public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}