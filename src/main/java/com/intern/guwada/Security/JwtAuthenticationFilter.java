package com.intern.guwada.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intern.guwada.Components.LogInModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

//jwtAUthenicationFiler extends UsernamePasswordAthenticaioinFilter and overrides two methods
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {


        String token= Jwts.builder()
                .setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis()+JwtProperties.EXPIRE))
                .signWith(SignatureAlgorithm.HS512,JwtProperties.SECRET.getBytes()).compact();



            response.getWriter().println(JwtProperties.TOKE_PREFIX+token);

    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //Accepts user name and password
        LogInModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LogInModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }



        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword(), new ArrayList<>());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //returned to successfulAUthenticatioin method
        return authentication;
    }
}
