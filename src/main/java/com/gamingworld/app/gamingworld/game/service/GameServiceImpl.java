package com.gamingworld.app.gamingworld.game.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;
import com.gamingworld.app.gamingworld.game.domain.persistence.GameRepository;
import com.gamingworld.app.gamingworld.game.domain.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public Game save(Game entity) {
        return gameRepository.save(entity);
    }

}
