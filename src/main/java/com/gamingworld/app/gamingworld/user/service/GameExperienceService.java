package com.gamingworld.app.gamingworld.user.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.user.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.user.domain.persitence.GameExperienceRepository;

import org.springframework.stereotype.Service;

@Service
public class GameExperienceService {
    
    private GameExperienceRepository gameRepository;

    public List<GameExperience> getAll() {
        return gameRepository.findAll();
    }

    public Optional<GameExperience> findById(Long id){
        return gameRepository.findById(id);
    }

    public GameExperience save(GameExperience gameExperience){
        return gameRepository.save(gameExperience);
    }
}
