package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class SecandFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("secandFilter 进去");
        chain.doFilter(req, resp);
        System.out.println("secandFilter 离开");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
