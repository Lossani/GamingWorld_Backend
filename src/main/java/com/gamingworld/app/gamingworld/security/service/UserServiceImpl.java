package com.gamingworld.app.gamingworld.security.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.profile.domain.persitence.ProfileRepository;
import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import com.gamingworld.app.gamingworld.security.domain.persistence.UserRepository;
import com.gamingworld.app.gamingworld.security.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User entity){

        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.addAuthority("ROLE_USER");

        User newUser = userRepository.save(entity);
        Profile newProfile = new Profile();
        newProfile.setUser(newUser);

        profileRepository.save(newProfile);
        return newUser;
    }
}
