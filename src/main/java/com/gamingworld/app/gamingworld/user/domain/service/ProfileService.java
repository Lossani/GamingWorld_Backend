package com.gamingworld.app.gamingworld.user.domain.service;

import java.util.List;
import java.util.Optional;

import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;

public interface ProfileService {
    public List<Profile> getAll();
    public Optional<Profile> findById(Long id);
}
