package com.example.api_project.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/login") || request.getServletPath().equals("/user/save")  ){
            filterChain.doFilter(request,response);
        }else{
            String authorizationHeader = request.getHeader("access_token");
            if(authorizationHeader != null){
                try {
                    String token = authorizationHeader;
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(token);
                    String username = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                    System.out.println(username+" "+roles.toString());
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    Arrays.stream(roles).forEach(role -> {
                        authorities.add(new SimpleGrantedAuthority(role));
                    });
                    authorities.forEach(r->{
                        System.out.println(r.getAuthority());
                    });
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,null,authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request,response);
                }catch (Exception exception){
                    response.setHeader("error",exception.getMessage());
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    Map<String,String> error = new HashMap<>();
                    error.put("error",exception.getMessage());
                    response.setContentType("application/json");
                    new ObjectMapper().writeValue(response.getOutputStream(),error);
                }
            }else {
                filterChain.doFilter(request,response);
            }
        }
    }


}


