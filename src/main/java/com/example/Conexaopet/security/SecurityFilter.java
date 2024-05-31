package com.example.Conexaopet.security;

import com.example.Conexaopet.repositories.OngsRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;
    @Autowired
    OngsRepository ongsRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToker(request);

        if (token != null){
            var subject = tokenService.tokenIsValid((String) token);
            UserDetails user = ongsRepository.findByEmail(subject);

            var authentication = new UsernamePasswordAuthenticationToken(user , null , user.getAuthorities());

            SecurityContextHolder.getContext().getAuthentication();
        }else {
            filterChain.doFilter(request , response);
        }
    }

    private Object recoverToker(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer" , "");
    }
}
