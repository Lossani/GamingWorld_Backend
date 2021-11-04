package com.gamingworld.app.gamingworld.user.api;

import java.util.List;

import javax.websocket.server.PathParam;

import com.gamingworld.app.gamingworld.user.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.user.domain.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/profiles")
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "")
    public List<Profile> getAll(){
        return profileService.getAll();
    }

    @PostMapping(path = "/{id}/game-experiences")
    public GameExperience addGameExperience(@RequestBody GameExperience gameExperience,
        @PathParam("id") Long id){
        return profileService.addGameExperience(gameExperience, id);
    }
}
