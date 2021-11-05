package com.gamingworld.app.gamingworld.user.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.user.domain.model.entity.GameExperience;

public interface GameExperienceService {
    public List<GameExperience> getAll();
    public Optional<GameExperience> findById(Long id);
    public GameExperience save(GameExperience gameExperience);
    public void deleteById(Long id);
}
