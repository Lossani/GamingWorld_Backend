package com.gamingworld.app.gamingworld.security.config.api;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import com.gamingworld.app.gamingworld.security.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "")
    public @ResponseBody List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping(path = "/email")
    public @ResponseBody
    Optional<User> getByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }



    @PostMapping(path = "/signup",consumes = "application/json", produces = "application/json")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
}
