package com.it355.authentification;

import com.it355.dao.UserDao;
import com.it355.models.User;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDao userDao;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        Optional<User> userOptional = userDao.findByUsername(username);

        if (!userOptional.isPresent()) {
            throw new BadCredentialsException("Username not found.");
        }

        User user = userOptional.get();

        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new GrantedAuthorityUser());

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    public boolean supports(Class<?> arg0) {
        return true;
    }
}
