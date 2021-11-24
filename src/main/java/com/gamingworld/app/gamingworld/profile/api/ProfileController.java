package com.gamingworld.app.gamingworld.profile.api;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.profile.domain.service.ProfileService;
import com.gamingworld.app.gamingworld.profile.mapping.ProfileMapper;
import com.gamingworld.app.gamingworld.profile.resource.ProfileResource;
import com.gamingworld.app.gamingworld.profile.resource.SaveProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/profiles")
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileMapper mapper;

    @GetMapping(path = "")
    public List<Profile> getAll(){
        return profileService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Profile getById(@PathVariable("id") Long profileId){
        return profileService.findById(profileId);
    }

    @GetMapping(path = "/user/{userId}")
    public Profile getByUserId(@PathVariable("userId") Long userId){
        return profileService.findByUserId(userId);
    }

    /* We automatically create a profile for new users, so we do not need extra profiles for now.
    @PostMapping(path = "")
    public ProfileResource create(@RequestBody SaveProfileResource profile){
        return mapper.toResource(profileService.create(mapper.toModel(profile)));
    }
    */

    @PutMapping(path = "/{userId}")
    public ProfileResource updateByUserId(@PathVariable("userId") Long userId, @RequestBody SaveProfileResource profile){
        return mapper.toResource(profileService.updateByUserId(userId, mapper.toModel(profile)));
    }
}
