package com.gamingworld.app.gamingworld.tournament.domain.persitence;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

//    @Query(value = "SELECT * FROM tournament t WHERE t.user_id = ?1", nativeQuery = true)
//    public List<Tournament> findByUserId (Long tournamentId);

    @Query(value = "SELECT * FROM participant p WHERE p.tournament_id = ?1", nativeQuery = true)
    public List<Participant> findByTournamentId (Long tournamentId);
    
}
