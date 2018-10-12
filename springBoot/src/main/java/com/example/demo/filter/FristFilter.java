package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter", urlPatterns = "/frist")
public class FristFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入过滤器");
        chain.doFilter(req, resp);
        System.out.println("离开过滤器");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
