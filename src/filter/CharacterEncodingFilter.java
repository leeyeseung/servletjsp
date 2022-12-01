package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	private String encoding;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encoding") != null) {
			encoding = filterConfig.getInitParameter("encoding");
		} else {
			encoding = "UTF-8";
		}
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) 
			throws IOException, ServletException {
		//전처리 : 코드를 기준으로 전에 처리함
		//System.out.println("전처리1 합니다");
		request.setCharacterEncoding(encoding);
		
		//-----------------------------------------------------------------------
		//이 필터 다음에 또 필터가 있으면 필터로 이동하고 없으면 서블릿으로 이동함
		filterChain.doFilter(request, response); //다음 필터 또는 서블릿으로 이동
		//-----------------------------------------------------------------------
		
		//후처리 : 코드를 기준으로 후에 처리함
		//System.out.println("후처리1 합니다");
		
	}

}
