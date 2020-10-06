package kr.or.ddit.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//
public class DriverLoader extends HttpServlet {

	private static ResourceBundle bundle;
	
	
	@Override
	public void init() throws ServletException {
	bundle = ResourceBundle.getBundle("dbinfo");
		
		try {
			
			
			Class.forName(bundle.getString("driver"));
			System.out.println("드라이버 로딩성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
	public static Connection getConnection(){
		
		
		try {
			return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
//			e.printStackTrace();
			return null;
		}
		
	}
	
}
