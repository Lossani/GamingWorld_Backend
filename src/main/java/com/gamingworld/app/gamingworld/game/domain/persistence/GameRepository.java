package com.gamingworld.app.gamingworld.game.domain.persitence;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    
}
