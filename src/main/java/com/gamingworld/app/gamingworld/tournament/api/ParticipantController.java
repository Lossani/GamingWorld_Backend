package com.gamingworld.app.gamingworld.tournament.api;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Participant;
import com.gamingworld.app.gamingworld.tournament.domain.service.ParticipantService;
import com.gamingworld.app.gamingworld.tournament.mapping.ParticipantMapper;
import com.gamingworld.app.gamingworld.tournament.mapping.TournamentMapper;
import com.gamingworld.app.gamingworld.tournament.resource.CreateParticipantResource;
import com.gamingworld.app.gamingworld.tournament.resource.ParticipantResource;
import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.user.domain.persitence.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ParticipantMapper mapper;

    @GetMapping("")
    public List<Participant> getAllParticipants() {
        return participantService.getAll();
    }

    @GetMapping("/{tournamentId}")
    public List<Participant> getAllParticipantsByTournamentId(@PathVariable("tournamentId") Long tournamentId) {
        return participantService.getAllByTournamentId(tournamentId);
    }

    @PostMapping("")
    public ParticipantResource createParticipant(@RequestBody CreateParticipantResource request) {
        Profile participantProfile = profileRepository.getById(request.getParticipantProfileId());
        Participant participant = mapper.toModel(request);
        participant.setParticipantProfile(participantProfile);

        return mapper.toResource(participantService.create(participant));
    }
}
