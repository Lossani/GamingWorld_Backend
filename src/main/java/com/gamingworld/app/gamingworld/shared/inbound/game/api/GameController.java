package com.gamingworld.app.gamingworld.shared.inbound.game.api;

import com.gamingworld.app.gamingworld.shared.inbound.game.domain.model.entity.Game;
import com.gamingworld.app.gamingworld.shared.inbound.game.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping(path = "")
    public List<Game> getRandomList() {
        return gameService.getRandomList(10);
    }

    @GetMapping(path = "/{id}")
    public Optional<Game> findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @GetMapping(path = "", params = {"find", "limit"})
    public List<Game> findByName(@RequestParam("find") String name, @RequestParam("limit") Integer limit) {
        if (limit == null)
            limit = 10;

        return gameService.findByName(name, limit);
    }

    @GetMapping(path = "/top", params = {"limit"})
    public String findTopGames(@RequestParam("limit") Integer limit) {
        return gameService.getTopTwitchGames(limit);
    }

    @GetMapping(path = "/top")
    public String findTopGames() {
        return gameService.getTopTwitchGames(5);
    }
}
