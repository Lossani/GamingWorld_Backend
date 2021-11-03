package com.gamingworld.app.gamingworld.user.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.user.domain.model.entity.User;
import com.gamingworld.app.gamingworld.user.domain.persitence.ProfileRepository;
import com.gamingworld.app.gamingworld.user.domain.persitence.UserRepository;
import com.gamingworld.app.gamingworld.user.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
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
    public User save(User entity){
        User newUser = userRepository.save(entity);
        Profile newProfile = new Profile();
        newProfile.setUser(newUser);
        profileRepository.save(newProfile);
        return newUser;
    }
}
