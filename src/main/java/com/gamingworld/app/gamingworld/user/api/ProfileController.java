package com.gamingworld.app.gamingworld.user.api;

import java.util.List;

import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.user.domain.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
