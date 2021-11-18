package com.gamingworld.app.gamingworld.tournament.api;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Participant;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Team;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.TeamParticipant;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;
import com.gamingworld.app.gamingworld.tournament.domain.service.ParticipantService;
import com.gamingworld.app.gamingworld.tournament.domain.service.TeamParticipantService;
import com.gamingworld.app.gamingworld.tournament.domain.service.TeamService;
import com.gamingworld.app.gamingworld.tournament.domain.service.TournamentService;
import com.gamingworld.app.gamingworld.tournament.mapping.ParticipantMapper;
import com.gamingworld.app.gamingworld.tournament.mapping.TeamMapper;
import com.gamingworld.app.gamingworld.tournament.mapping.TeamParticipantMapper;
import com.gamingworld.app.gamingworld.tournament.mapping.TournamentMapper;
import com.gamingworld.app.gamingworld.tournament.resource.*;
import com.gamingworld.app.gamingworld.profile.domain.persitence.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamParticipantService teamParticipantService;

    @Autowired
    private TournamentMapper tournamentMapper;

    @Autowired
    private ParticipantMapper participantMapper;

    @Autowired
    private TeamParticipantMapper teamParticipantMapper;

    @Autowired
    private TeamMapper teamMapper;

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<Tournament> getTournamentsByUserId(@PathVariable("userId") Long userId) {
        return tournamentService.getTournamentsByUserId(userId);
    }

    @GetMapping("{tournamentId}")
    public Tournament getTournamentById(@PathVariable("tournamentId") Long tournamentId) {
        return tournamentService.getById(tournamentId);
    }

    @PostMapping("{userId}/create")
    public TournamentResource createTournament(@RequestBody CreateTournamentResource request, @PathVariable("userId") Long userId) {
        return tournamentMapper.toResource(tournamentService.create(userId,tournamentMapper.toModel(request)));
    }

    // Participants
    @PostMapping("{tournamentId}/participants")
    public ParticipantResource createParticipantByTournamentId(@RequestBody CreateParticipantResource request, @PathVariable("tournamentId") Long tournamentId) {

        return participantMapper.toResource(participantService.create(tournamentId, participantMapper.toModel(request)));
    }

    @GetMapping("{tournamentId}/participants")
    public List<Participant> getAllParticipantsByTournamentId(@PathVariable("tournamentId") Long tournamentId) {
        return participantService.getAllByTournamentId(tournamentId);
    }

    @PutMapping("{tournamentId}/participants/{participantId}")
    public ParticipantResource updateParticipantPoints(@PathVariable("tournamentId") Long tournamentId, @PathVariable("participantId") Long participantId, @RequestParam int points){
        return participantMapper.toResource(tournamentService.updateParticipantPoints(tournamentId, participantId, points));
    }

    @DeleteMapping("{tournamentId}/participants/{participantId}")
    public ResponseEntity<?> deleteParticipantInTournament(@PathVariable("tournamentId") Long tournamentId, @PathVariable("participantId") Long participantId){
        return tournamentService.deleteParticipantInTournament(tournamentId, participantId);
    }

    // TEAMS

    @PostMapping("{tournamentId}/teams")
    public TeamResource createTeamByTournamentId(@RequestBody CreateTeamResource request, @PathVariable("tournamentId") Long tournamentId) {

        return teamMapper.toResource(teamService.create(tournamentId, teamMapper.toModel(request)));
    }

    @GetMapping("{tournamentId}/teams")
    public List<Team> getAllTeamsByTournamentId(@PathVariable("tournamentId") Long tournamentId) {
        return teamService.getAllByTournamentId(tournamentId);
    }

    @PutMapping("{tournamentId}/teams/{teamId}")
    public TeamResource updateTeamPoints(@PathVariable("tournamentId") Long tournamentId, @PathVariable("teamId") Long teamId, @RequestParam int points){
        return teamMapper.toResource(tournamentService.updateTeamPoints(tournamentId, teamId, points));
    }

    @DeleteMapping("{tournamentId}/teams/{teamId}")
    public ResponseEntity<?> deleteTeamInTournament(@PathVariable("teamId") Long teamId){
        return teamService.delete(teamId);
    }

    // Team Participants

    @PostMapping("{tournamentId}/teams/{teamId}/participants")
    public TeamParticipantResource createTeamParticipantByTeamId(@PathVariable("tournamentId") Long tournamentId, @RequestBody CreateTeamParticipantResource request, @PathVariable("teamId") Long teamId) {

        return teamParticipantMapper.toResource(teamParticipantService.create(tournamentId, teamId, teamParticipantMapper.toModel(request)));
    }

    @GetMapping("{tournamentId}/teams/{teamId}/participants")
    public List<TeamParticipant> getAllTeamParticipantsByTeamId(@PathVariable("teamId") Long teamId) {
        return teamParticipantService.getAllByTeamId(teamId);
    }

    @DeleteMapping("{tournamentId}/teams/{teamId}/participants/{teamParticipantId}")
    public ResponseEntity<?> deleteTeamParticipantInTeam(@PathVariable("teamParticipantId") Long teamParticipantId){
        return teamParticipantService.delete(teamParticipantId);
    }

    // -- Team Participants

    // -- TEAMS

    @PutMapping("{tournamentId}")
    public TournamentResource updateTournament(@PathVariable Long tournamentId, @RequestBody UpdateTournamentResource request) {
        return tournamentMapper.toResource(tournamentService.update(tournamentId, tournamentMapper.toModel(request)));
    }

    @DeleteMapping("{tournamentId}")
    public ResponseEntity<?> deleteTournament(@PathVariable Long tournamentId) {
        return tournamentService.delete(tournamentId);
    }

    @PutMapping("{tournamentId}/end")
    public TournamentResource endTournament(@PathVariable("tournamentId") Long tournamentId){
        return tournamentMapper.toResource(tournamentService.endTournament(tournamentId));
    }

}
