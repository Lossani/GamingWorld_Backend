package com.gamingworld.app.gamingworld.security.config.spring;

import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import com.gamingworld.app.gamingworld.security.domain.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retornando el usuario
        Optional<User> userFound = this.userRepository.findByUsername(username);

        if(userFound.isPresent()) {
            UserDetails userDetails = new UserDetails(userFound.get()) {
            };
            return userDetails;
        }
        throw new UsernameNotFoundException("Invalid User");

    }
}
