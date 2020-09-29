package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest02 implements Filter{

	@Override
	public void destroy() {
		System.out.println("2번째 filter - destroy 메서드 호출");
	}

	//실제 처리하는 부분
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		//chain.doFilter()메서드 앞쪽은 요청에 관련된 처리를 구현한다. 
		System.out.println("2번째 filter  - doFilter() 메서드 호출 전..");
		
		
		chain.doFilter(request, response); //다음필터로 체이닝 하는 메서드
		
		System.out.println("2번째 filter  - doFilter() 메서드 호출 후..");
		//chain.doFilter()메서드 뒤쪽은 응답에 관련된 처리를 구현한다.
	}

	// 초기화 부분
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2번째 filter - init() 메서드 호출");
		// 초기화 파라미터 정보 가져오기
		String paramValue1 = filterConfig.getInitParameter("tester");
		System.out.println("tester : "+ paramValue1);
		String paramValue2 = filterConfig.getInitParameter("date");
		System.out.println("date : "+ paramValue2);
		
	}
		
		
}
