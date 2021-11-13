package com.gamingworld.app.gamingworld.profile.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.profile.domain.persitence.GameExperienceRepository;
import com.gamingworld.app.gamingworld.profile.domain.persitence.ProfileRepository;
import com.gamingworld.app.gamingworld.profile.domain.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private GameExperienceRepository gameExperienceRepository;

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public GameExperience addGameExperience(GameExperience gameExperience, Long id){
        GameExperience newGameExperience = gameExperienceRepository.save(gameExperience);
        Profile auxProfile = profileRepository.getById(id);
        auxProfile.addGameExperience(newGameExperience);
        return newGameExperience;
    }
}
