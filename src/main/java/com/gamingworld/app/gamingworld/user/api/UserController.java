package com.gamingworld.app.gamingworld.user.api;

import java.util.List;

import com.gamingworld.app.gamingworld.user.domain.model.entity.User2;
import com.gamingworld.app.gamingworld.user.service.UserServiceImpl;

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
    public @ResponseBody List<User2> getAll(){
        return userService.getAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "")
    public User2 saveUser(@RequestBody User2 user2){
        return userService.save(user2);
    }
}
