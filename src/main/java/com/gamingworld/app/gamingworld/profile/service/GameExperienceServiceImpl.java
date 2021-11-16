package com.gamingworld.app.gamingworld.profile.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.profile.domain.persitence.GameExperienceRepository;
import com.gamingworld.app.gamingworld.profile.domain.service.GameExperienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameExperienceServiceImpl implements GameExperienceService {
    
    @Autowired
    private GameExperienceRepository gameRepository;

    @Override
    public List<GameExperience> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<GameExperience> findById(Long id){
        return gameRepository.findById(id);
    }

    @Override
    public GameExperience save(GameExperience gameExperience){
        return gameRepository.save(gameExperience);
    }

    @Override
    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }
}
