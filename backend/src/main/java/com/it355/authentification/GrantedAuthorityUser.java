package com.it355.authentification;

import com.it355.utils.Constants;
import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityUser implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return Constants.USER;
    }
}
