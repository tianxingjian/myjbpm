package cn.com.myjbpm.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.myjbpm.center.model.Ywuser;


/**
 * Session Filter
 * 
 * @author shiyt
 * @date Sep 27, 2009
 */
public class SessionFilter implements Filter {

    public void init(FilterConfig filterconfig) throws ServletException {
    }

    public void destroy() {
    	
    }

    /** 过滤方法 */
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	// 对SESSION是否有效进行校验
    	boolean flag = checkSession((HttpServletRequest) request,
				(HttpServletResponse) response);
    	if (flag){
    		chain.doFilter(request, response);
    	}
    }

	/** 校验SESSION是否有效，主要判断session里面是否有user */
	private boolean checkSession(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		String URI = request.getRequestURI();
    	// 如果是其实页面就返回真
		if (URI.contains("index.jsp") || URI.endsWith("/myjbpm/") || URI.endsWith("/myjbpm"))
			return true;
		if (request.getParameter("usercode") != null
				&& request.getParameter("password") != null) {
			return true;
		} else { // 如果不是在登陆，则需要判断是否有user
			String user = (String) session.getAttribute("user");
			if (user == null) {
				try {
					response.sendRedirect("/myjbpm");
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return true;
	}
}
