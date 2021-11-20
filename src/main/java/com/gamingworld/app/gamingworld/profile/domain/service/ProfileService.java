package com.gamingworld.app.gamingworld.profile.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.security.domain.model.entity.User;

public interface ProfileService {
    public List<Profile> getAll();
    public Profile findById(Long id);
    public Profile findByUserId(Long userId);
    //public Profile create(Profile profile);
    public Profile updateByUserId(Long userId, Profile newProfile);
    //public GameExperience addGameExperience(GameExperience gameExperience, Long id);
}
