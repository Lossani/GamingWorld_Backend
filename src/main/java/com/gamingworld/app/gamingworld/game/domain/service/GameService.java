package com.gamingworld.app.gamingworld.game.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;

public interface GameService {
    public List<Game> getAll();
    public Optional<Game> findById(Long id);
    public Game save(Game entity);
}
