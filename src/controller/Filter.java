package controller;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.*; 

import javax.servlet.http.*; 
  
@WebFilter (filterName = "MyFilter", urlPatterns = {"/*"})
public class Filter implements javax.servlet.Filter{
	 public void destroy() {
	    }

	    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
	        
	        req.setCharacterEncoding("UTF-8");
	        chain.doFilter(req, resp);
	    }

	    public void init(FilterConfig config) throws ServletException {

	    }
}