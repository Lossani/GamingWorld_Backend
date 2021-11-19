package com.gamingworld.app.gamingworld.shared.inbound.game.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.shared.inbound.game.domain.model.entity.Game;

public interface GameService {
    public List<Game> getRandomList(Integer limit);
    public Optional<Game> findById(Long id);
    public List<Game> findByName(String name, Integer limit);
}
