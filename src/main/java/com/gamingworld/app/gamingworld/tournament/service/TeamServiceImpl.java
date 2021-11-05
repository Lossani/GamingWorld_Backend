package com.gamingworld.app.gamingworld.tournament.service;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Team;
import com.gamingworld.app.gamingworld.tournament.domain.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Override
    public List<Team> getAll() {
        return null;
    }

    @Override
    public Team getById(Long teamId) {
        return null;
    }

    @Override
    public List<Team> getAllByTournamentId(Long tournamentId) {
        return null;
    }

    @Override
    public Team create(Long tournamentId, Team team) {
        return null;
    }

    @Override
    public Team update(Long tournamentId, Team team) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long teamId) {
        return null;
    }

    @Override
    public List<Team> getTournamentsByUserId(Long userId) {
        return null;
    }
}
