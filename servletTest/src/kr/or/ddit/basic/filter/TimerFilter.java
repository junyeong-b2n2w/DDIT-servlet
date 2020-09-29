package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimerFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {

		Long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		Long endTime = System.currentTimeMillis();
		
		System.out.println(endTime);
		System.out.println(startTime);
		System.out.println(endTime-startTime + "밀리 초 소요되었습니다");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
