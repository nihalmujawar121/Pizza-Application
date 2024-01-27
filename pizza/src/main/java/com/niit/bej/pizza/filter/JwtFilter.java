package com.niit.bej.pizza.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;


public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            throw new ServletException("Token is Missing");
        } else {
            System.out.println("Authorization key" + authHeader);

            String token = authHeader.substring(7);

            Claims claims = Jwts.parser().setSigningKey("password").parseClaimsJws(token).getBody();
            System.out.println("Claims from Token" + claims);
            httpServletRequest.setAttribute("userEmailId", claims.get("userEmailId"));
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}