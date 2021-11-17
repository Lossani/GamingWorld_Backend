package com.gamingworld.app.gamingworld.profile.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.gamingworld.app.gamingworld.profile.domain.model.entity.*;
import com.gamingworld.app.gamingworld.profile.domain.persitence.*;
import com.gamingworld.app.gamingworld.profile.domain.service.ProfileService;

import com.gamingworld.app.gamingworld.security.domain.persistence.UserRepository;
import com.gamingworld.app.gamingworld.shared.exception.ResourceNotFoundException;
import com.gamingworld.app.gamingworld.shared.exception.ResourceValidationException;
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

    @Autowired
    private FavoriteGameRepository favoriteGameRepository;

    @Autowired
    private StreamerSponsorRepository streamerSponsorRepository;

    @Autowired
    private StreamingCategoryRepository streamingCategoryRepository;

    @Autowired
    private TournamentExperienceRepository tournamentExperienceRepository;

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(Long id) {
        return profileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    /* We automatically create a profile for new users, so we do not need extra profiles for now.
    @Override
    public Profile create(Profile profile) {
        Set<ConstraintViolation<Profile>> violations = validator.validate(profile);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        User user = userRepository.getById(profile.getUser().getId());
        profile.setUser(user);
        return profileRepository.save(profile);
    }
    */

    @Override
    public Profile updateByUserId(Long userId, Profile newProfile) {
        Set<ConstraintViolation<Profile>> violations = validator.validate(newProfile);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("USER", userId);

        Profile currentProfile = profileRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));

        gameExperienceRepository.saveAll(newProfile.getGameExperiences());
        favoriteGameRepository.saveAll(newProfile.getFavoriteGames());
        streamerSponsorRepository.saveAll(newProfile.getStreamerSponsors());
        streamingCategoryRepository.saveAll(newProfile.getStreamingCategories());
        tournamentExperienceRepository.saveAll(newProfile.getTournamentExperiences());

        // We delete previous elements that are non present in the update request

        List<GameExperience> deletedGameExperiences = currentProfile.getGameExperiences();
        deletedGameExperiences.removeAll(newProfile.getGameExperiences());

        List<FavoriteGame> deletedFavoriteGames = currentProfile.getFavoriteGames();
        deletedFavoriteGames.removeAll(newProfile.getFavoriteGames());

        List<StreamerSponsor> deletedStreamerSponsors = currentProfile.getStreamerSponsors();
        deletedStreamerSponsors.removeAll(newProfile.getStreamerSponsors());

        List<StreamingCategory> deletedStreamingCategories = currentProfile.getStreamingCategories();
        deletedStreamingCategories.removeAll(newProfile.getStreamingCategories());

        List<TournamentExperience> deletedTournamentExperiences = currentProfile.getTournamentExperiences();
        deletedTournamentExperiences.removeAll(newProfile.getTournamentExperiences());

        gameExperienceRepository.deleteAll(deletedGameExperiences);
        favoriteGameRepository.deleteAll(deletedFavoriteGames);
        streamerSponsorRepository.deleteAll(deletedStreamerSponsors);
        streamingCategoryRepository.deleteAll(deletedStreamingCategories);
        tournamentExperienceRepository.deleteAll(deletedTournamentExperiences);


        return profileRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }
}
