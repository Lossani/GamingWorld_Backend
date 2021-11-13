package com.gamingworld.app.gamingworld.security.config.spring;

import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;

    public UserDetails(User user) {
        super();
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        // Extraer la lista de las Authorities
        this.user.getAuthorities().forEach(authority -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantedAuthorities.add(grantedAuthority);
        });

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnable();
    }


    public String getName() {
        return this.user.getName();
    }
    public String getLastName() {
        return this.user.getLastName();
    }
    public String getRole() {

        return this.user.getRole();
    }
}
