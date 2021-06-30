package com.huongdanjava.springsecurity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher(
            "/login-token", "POST");

    @Autowired
    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter() {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
    }

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        this.logger.info("Authenticating ...");

        String username = getUsername(request);
        String token = request.getParameter("token");

        validateUsernameAndToken(username, token);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        return authentication;
    }

    private String getUsername(HttpServletRequest httpRequest) {
        String username = httpRequest.getParameter("username");
        if (username == null) {
            return "";
        }

        return username;
    }

    private boolean validateUsernameAndToken(String username, String token) {
        try {
            userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            this.logger.debug("Failed to find user '" + username + "'");
            throw new BadCredentialsException(this.messages
                    .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        Map<String, String> map = new HashMap<>();
        map.put("123", "user");

        if (map.containsKey(token)) {
            String user = map.get(token);
            if (user.equals(username)) {
                return true;
            }
        }

        this.logger.debug("No user '" + username + "' associate with the token " + token);
        throw new BadCredentialsException(this.messages
                .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
    }

}
