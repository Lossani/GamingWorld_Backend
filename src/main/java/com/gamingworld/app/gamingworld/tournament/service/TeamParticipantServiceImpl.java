package com.gamingworld.app.gamingworld.tournament.service;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.TeamParticipant;
import com.gamingworld.app.gamingworld.tournament.domain.service.TeamParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamParticipantServiceImpl implements TeamParticipantService {
    @Override
    public List<TeamParticipant> getAll() {
        return null;
    }

    @Override
    public TeamParticipant getById(Long participantId) {
        return null;
    }

    @Override
    public TeamParticipant getByTournamentId(Long tournamentId) {
        return null;
    }

    @Override
    public List<TeamParticipant> getAllByTeamId(Long teamId) {
        return null;
    }

    @Override
    public TeamParticipant create(Long teamId, TeamParticipant teamParticipant) {
        return null;
    }

    @Override
    public TeamParticipant update(Long teamId, TeamParticipant teamParticipant) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long teamParticipantId) {
        return null;
    }
}
