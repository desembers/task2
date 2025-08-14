package com.example.scedule2.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class AuthFilter extends OncePerRequestFilter {

    private static final List<String> WHITELIST = List.of(
            "/auth/login", "/auth/signup"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();

        // 로그인, 회원가입은 제외
        if (WHITELIST.contains(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("인증이 필요합니다.");
            return;
        }

        filterChain.doFilter(request, response);
    }
}