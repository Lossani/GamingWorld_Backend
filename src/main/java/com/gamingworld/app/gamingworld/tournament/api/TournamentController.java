package com.gamingworld.app.gamingworld.tournament.api;

import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;
import com.gamingworld.app.gamingworld.tournament.domain.service.TournamentService;
import com.gamingworld.app.gamingworld.tournament.mapping.TournamentMapper;
import com.gamingworld.app.gamingworld.tournament.resource.CreateTournamentResource;
import com.gamingworld.app.gamingworld.tournament.resource.TournamentResource;
import com.gamingworld.app.gamingworld.tournament.resource.UpdateTournamentResource;
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
    private TournamentMapper mapper;

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

    @PutMapping("{tournamentId}")
    public TournamentResource updateTournament(@PathVariable Long tournamentId, @RequestBody UpdateTournamentResource request) {
        return mapper.toResource(tournamentService.update(tournamentId, mapper.toModel(request)));
    }

    @DeleteMapping("{tournamentId}")
    public ResponseEntity<?> deleteTournament(@PathVariable Long tournamentId) {
        return tournamentService.delete(tournamentId);
    }

}
