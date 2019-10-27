package com.team.house.filter;

import com.team.house.entity.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("userInfo");
        String path=request.getRequestURI();
        if(path.indexOf("/guanli.jsp")>-1){
            if (user == null) {
                response.sendRedirect("/page/login.jsp");
            } else {
                //放行
                filterChain.doFilter(request, response);
            }
        }else{
            //放行
            filterChain.doFilter(request, response);
        }
    }
    @Override
    public void destroy() {

    }
}
