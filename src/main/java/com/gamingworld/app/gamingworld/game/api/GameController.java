package com.gamingworld.app.gamingworld.game.api;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;
import com.gamingworld.app.gamingworld.game.domain.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Game> findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @PostMapping(path = "")
    public Game save(@RequestBody Game entity){
        return gameService.save(entity);
    }
}
