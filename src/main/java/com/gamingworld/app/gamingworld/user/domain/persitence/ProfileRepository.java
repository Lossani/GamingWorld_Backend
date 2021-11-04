package com.gamingworld.app.gamingworld.user.domain.persitence;

import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
