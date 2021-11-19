package com.gamingworld.app.gamingworld.profile.domain.persitence;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;

import com.gamingworld.app.gamingworld.profile.resource.ProfileResource;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query(value = "SELECT p FROM Profile p WHERE p.user.id = :userId")
    public Optional<Profile> findByUserId (@Param("userId") Long userId);
}
