package com.gamingworld.app.gamingworld.profile.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.GameExperience;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;
import com.gamingworld.app.gamingworld.profile.domain.persitence.GameExperienceRepository;
import com.gamingworld.app.gamingworld.profile.domain.persitence.ProfileRepository;
import com.gamingworld.app.gamingworld.profile.domain.service.ProfileService;

import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import com.gamingworld.app.gamingworld.security.domain.persistence.UserRepository;
import com.gamingworld.app.gamingworld.shared.exception.ResourceNotFoundException;
import com.gamingworld.app.gamingworld.shared.exception.ResourceValidationException;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;
import com.gamingworld.app.gamingworld.tournament.domain.persitence.ParticipantRepository;
import com.gamingworld.app.gamingworld.tournament.domain.persitence.TeamRepository;
import com.gamingworld.app.gamingworld.tournament.domain.persitence.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Service
public class ProfileServiceImpl implements ProfileService{
    private final Validator validator;
    private static final String ENTITY = "Profile";
    private final UserRepository userRepository;


    public ProfileServiceImpl(Validator validator, UserRepository userRepository) {
        this.validator = validator;
        this.userRepository = userRepository;
    }

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private GameExperienceRepository gameExperienceRepository;

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(Long id) {
        return profileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Profile create(Profile profile) {
        Set<ConstraintViolation<Profile>> violations = validator.validate(profile);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        User user = userRepository.getById(profile.getUser().getId());
        profile.setUser(user);
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateByUserId(Long userId, Profile newProfile) {
        Set<ConstraintViolation<Profile>> violations = validator.validate(newProfile);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return profileRepository.findByUserId(userId).map(profile ->
                profileRepository.save(profile)
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public GameExperience addGameExperience(GameExperience gameExperience, Long id){
        GameExperience newGameExperience = gameExperienceRepository.save(gameExperience);
        Profile auxProfile = profileRepository.getById(id);
        auxProfile.addGameExperience(newGameExperience);
        return newGameExperience;
    }
}
