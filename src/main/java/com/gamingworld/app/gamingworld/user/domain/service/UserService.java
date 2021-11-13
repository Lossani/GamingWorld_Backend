package com.gamingworld.app.gamingworld.user.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.user.domain.model.entity.User2;

public interface UserService {
    public List<User2> getAll();

    public Optional<User2> findById(Long id);

    public User2 save(User2 entity);
}
