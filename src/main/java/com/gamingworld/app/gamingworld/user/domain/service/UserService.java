package com.gamingworld.app.gamingworld.user.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.user.domain.model.entity.User;

public interface UserService {
    public List<User> getAll();

    public Optional<User> findById(Long id);

    public User save(User entity);
}
