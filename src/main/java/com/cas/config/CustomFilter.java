package com.cas.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFilter extends OncePerRequestFilter {
       @Override
       protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
           // 在这里可以检查请求，修改请求/响应对象，或者改变Spring Security的处理逻辑
           // ...

           chain.doFilter(request, response); // 调用下一个过滤器
       }
   }