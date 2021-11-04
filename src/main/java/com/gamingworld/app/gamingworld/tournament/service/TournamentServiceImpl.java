package com.gamingworld.app.gamingworld.tournament.service;

import com.gamingworld.app.gamingworld.tournament.shared.exception.ResourceNotFoundException;
import com.gamingworld.app.gamingworld.tournament.shared.exception.ResourceValidationException;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;
import com.gamingworld.app.gamingworld.tournament.domain.persitence.TournamentRepository;
import com.gamingworld.app.gamingworld.tournament.domain.service.TournamentService;
import com.gamingworld.app.gamingworld.user.domain.model.entity.User;
import com.gamingworld.app.gamingworld.user.domain.persitence.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


@Service
public class TournamentServiceImpl implements TournamentService {

    private static final String ENTITY = "Tournament";

    private final TournamentRepository tournamentRepository;

    private final Validator validator;

    private final UserRepository userRepository;


    public TournamentServiceImpl(TournamentRepository tournamentRepository, Validator validator, UserRepository userRepository) {
        this.tournamentRepository = tournamentRepository;
        this.validator = validator;
        this.userRepository = userRepository;
    }


    @Override
    public List<Tournament> getAll() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament getById(Long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, tournamentId));
    }

    @Override
    public Tournament create(Long userId, Tournament tournament) {
        Set<ConstraintViolation<Tournament>> violations = validator.validate(tournament);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        User tournamentManager = userRepository.getById(userId);
        tournament.setUser(tournamentManager);
        return tournamentRepository.save(tournament);
    }

    @Override
    public Tournament update(Long tournamentId, Tournament request) {

        Set<ConstraintViolation<Tournament>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return tournamentRepository.findById(tournamentId).map(tournament ->
                tournamentRepository.save(
                        tournament.withTitle(request.getTitle())
                                .withDescription(request.getDescription())
                                .withPrizePool(request.getPrizePool()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, tournamentId));
    }

    @Override
    public ResponseEntity<?> delete(Long tournamentId) {
        return tournamentRepository.findById(tournamentId).map(tournament -> {
            tournamentRepository.delete(tournament);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, tournamentId));
    }

    @Override
    public List<Tournament> getTournamentsByUserId(Long userId) {
        return tournamentRepository.findByUserId(userId);
    }
}
