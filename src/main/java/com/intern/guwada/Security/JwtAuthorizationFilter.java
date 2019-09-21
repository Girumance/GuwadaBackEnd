package com.intern.guwada.Security;


import com.intern.guwada.Components.UserPrincipal;
import com.intern.guwada.Repository.AccountRepository;
import com.intern.guwada.Services.AccountService;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {


    AccountService userService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint, AccountService service) {
        super(authenticationManager, authenticationEntryPoint);
        this.userService =  userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(JwtProperties.HEADER_STRING);



        if(header==null || !header.startsWith(JwtProperties.TOKE_PREFIX)){
            chain.doFilter(request,response);
            return;
        }

        Authentication authentication=getUsernameAndPasswordAuthenticatioin(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request,response);
    }



    private Authentication getUsernameAndPasswordAuthenticatioin(HttpServletRequest req){

        String token=req.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKE_PREFIX,"");
        if(token!=null) {
            String user = Jwts.parser()
                    .setSigningKey(JwtProperties.SECRET.getBytes())
                    .parseClaimsJws(token.replace(JwtProperties.TOKE_PREFIX, ""))
                    .getBody()
                    .getSubject();



            if (user != null) {
                UserPrincipal userPrincipal = (UserPrincipal) userService.loadUserByUsername(user);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, userPrincipal.getAuthorities());
                return authenticationToken;
            }

            return null;
        }

        return  null;


    }
}
