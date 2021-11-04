package com.gamingworld.app.gamingworld.user.api;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.gamingworld.app.gamingworld.user.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.user.domain.service.GameExperienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/game-experiences")
public class GameExperienceController {
    
    @Autowired
    private GameExperienceService gameExperienceService;

    @GetMapping(path = "")
    public List<GameExperience> getAll() {
        return gameExperienceService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<GameExperience> getById(@PathParam(value = "id") Long id) {
        return gameExperienceService.findById(id);
    }

    @PostMapping(path = "")
    public GameExperience save(@RequestBody GameExperience gameExperience){
        return gameExperienceService.save(gameExperience);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void deleteById(@PathParam(value = "id") Long id){
        gameExperienceService.deleteById(id);
    }
}
