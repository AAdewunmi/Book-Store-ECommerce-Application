package com.bookstore.controller.frontend;

import java.io.IOException;
import java.net.http.HttpRequest;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {
	
	private static final String[] loginRequiredURLS = {
		"/view_profile", "/edit_profile", "/update_profile"	
	};
    
	public CustomerLoginFilter() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);
		String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		boolean loggedIn = (session != null) && (session.getAttribute("loggedCustomer") != null);
		String requestURL = httpServletRequest.getRequestURI().toString();
		System.out.println("Path: " + path);
		System.out.println("LoggedIn: " + loggedIn);
		if (!loggedIn && isLoginRequired(requestURL)) {
			String loginPage = "frontend/login.jsp";
			RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
	
	private boolean isLoginRequired(String requestURL) {
		for (String loginRequiredURL : loginRequiredURLS) {
			if (requestURL.contains(loginRequiredURL)) {
				return true;
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
