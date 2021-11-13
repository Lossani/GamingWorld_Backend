package com.gamingworld.app.gamingworld.security.config.api;

import java.util.List;

import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import com.gamingworld.app.gamingworld.security.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "")
    public @ResponseBody List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping(path = "/signup",consumes = "application/json", produces = "application/json")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
}
