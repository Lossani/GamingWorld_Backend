package com.gamingworld.app.gamingworld.user.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.user.domain.model.entity.User2;
import com.gamingworld.app.gamingworld.user.domain.persitence.ProfileRepository;
import com.gamingworld.app.gamingworld.user.domain.persitence.User2Repository;
import com.gamingworld.app.gamingworld.user.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private User2Repository user2Repository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<User2> getAll(){
        return user2Repository.findAll();
    }

    @Override
    public Optional<User2> findById(Long id){
        return user2Repository.findById(id);
    }

    @Override
    public User2 save(User2 entity){
        User2 newUser2 = user2Repository.save(entity);
        Profile newProfile = new Profile();
        newProfile.setUser2(newUser2);
        profileRepository.save(newProfile);
        return newUser2;
    }
}
