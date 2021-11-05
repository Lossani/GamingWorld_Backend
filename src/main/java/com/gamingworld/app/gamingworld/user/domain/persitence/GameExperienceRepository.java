package com.gamingworld.app.gamingworld.user.domain.persitence;

import com.gamingworld.app.gamingworld.user.domain.model.entity.GameExperience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameExperienceRepository extends JpaRepository<GameExperience, Long>{
    
}
