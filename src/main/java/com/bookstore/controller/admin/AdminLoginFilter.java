package com.bookstore.controller.admin;

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


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    public AdminLoginFilter() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession(false);
		boolean loggedIn = session != null && session.getAttribute("useremail") != null;
		String loginURI = httpServletRequest.getContextPath() + "/admin/login";
		boolean loginRequest = httpServletRequest.getRequestURI().equals(loginURI);
		boolean loginPage = httpServletRequest.getRequestURI().endsWith("login.jsp");
		
		if (loggedIn && (loginRequest || loginPage)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
		}else if (loggedIn || loginRequest) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
