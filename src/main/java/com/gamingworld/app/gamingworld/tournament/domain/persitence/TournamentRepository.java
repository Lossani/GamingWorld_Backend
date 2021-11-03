package com.gamingworld.app.gamingworld.tournament.domain.persitence;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    
}
