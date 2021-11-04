package com.gamingworld.app.gamingworld.game.api;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;
import com.gamingworld.app.gamingworld.game.domain.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping(path = "")
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Game> findById(@PathParam(value = "id") Long id) {
        return gameService.findById(id);
    }

    @PostMapping(path = "")
    public Game save(@RequestBody Game entity){
        return gameService.save(entity);
    }
}
