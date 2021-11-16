package com.gamingworld.app.gamingworld.profile.api;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.profile.domain.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/profiles")
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "")
    public List<Profile> getAll(){
        return profileService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Profile getById(@PathVariable("id") Long profileId){
        return profileService.findById(profileId);
    }

    @PostMapping(path = "/{id}")
    public Profile addGameExperience(@PathParam("id") Long profileId, @RequestBody Profile profile){
        return profileService.updateById(profileId, profile);
    }

    @PostMapping(path = "/{id}/game-experiences")
    public GameExperience addGameExperience(@RequestBody GameExperience gameExperience,
        @PathParam("id") Long id){
        return profileService.addGameExperience(gameExperience, id);
    }
}
