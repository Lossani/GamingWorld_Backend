package com.gamingworld.app.gamingworld.tournament.api;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Participant;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;
import com.gamingworld.app.gamingworld.tournament.domain.service.ParticipantService;
import com.gamingworld.app.gamingworld.tournament.domain.service.TournamentService;
import com.gamingworld.app.gamingworld.tournament.mapping.ParticipantMapper;
import com.gamingworld.app.gamingworld.tournament.mapping.TournamentMapper;
import com.gamingworld.app.gamingworld.tournament.resource.*;
import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.user.domain.persitence.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
    private TournamentMapper mapper;

    @Autowired
    private ParticipantMapper participantMapper;

    @GetMapping
    public Page<TournamentResource> getAllTournaments(Pageable pageable) {
        return mapper.modelListToPage(tournamentService.getAll(), pageable);
    }

    @GetMapping("/user/{userId}")
    public List<Tournament> getTournamentsByUserId(@PathVariable("userId") Long userId) {
        return tournamentService.getTournamentsByUserId(userId);
    }

    @GetMapping("{tournamentId}")
    public TournamentResource getTournamentById(@PathVariable("tournamentId") Long tournamentId) {


        return mapper.toResource(tournamentService.getById(tournamentId));
    }

    @PostMapping("{userId}/create")
    public TournamentResource createTournament(@RequestBody CreateTournamentResource request, @PathVariable("userId") Long userId) {
        return mapper.toResource(tournamentService.create(userId,mapper.toModel(request)));
    }

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



    @PutMapping("{tournamentId}")
    public TournamentResource updateTournament(@PathVariable Long tournamentId, @RequestBody UpdateTournamentResource request) {
        return mapper.toResource(tournamentService.update(tournamentId, mapper.toModel(request)));
    }

    @DeleteMapping("{tournamentId}")
    public ResponseEntity<?> deleteTournament(@PathVariable Long tournamentId) {
        return tournamentService.delete(tournamentId);
    }

}
