package com.gamingworld.app.gamingworld.profile.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;

public interface ProfileService {
    public List<Profile> getAll();
    public Profile findById(Long id);
    public Profile create(Long userId, Profile profile);
    public Profile updateById(Long profileId, Profile newProfile);
    public GameExperience addGameExperience(GameExperience gameExperience, Long id);
}
