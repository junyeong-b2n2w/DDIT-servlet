package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomEncodingFilter implements Filter {
	private String encoding;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		
		// 요청에 대한 인코딩 설정
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
		//응답에 대한 인코딩 설정
		response.setCharacterEncoding(encoding);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 
		if(filterConfig.getInitParameter("encoding")==null){
			encoding = "utf-8";
		}else{
			encoding = filterConfig.getInitParameter("encoding");
		}
		 
		
		
		
		
	}

}
