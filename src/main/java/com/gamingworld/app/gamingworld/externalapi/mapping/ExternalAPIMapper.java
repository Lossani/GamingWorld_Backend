package com.gamingworld.app.gamingworld.externalapi.mapping;

import com.gamingworld.app.gamingworld.externalapi.domain.model.entity.ExternalAPI;
import com.gamingworld.app.gamingworld.externalapi.resource.TwitchOAuthResponseResource;
import com.gamingworld.app.gamingworld.shared.mapping.EnhancedModelMapper;
import com.gamingworld.app.gamingworld.tournament.domain.model.entity.Tournament;
import com.gamingworld.app.gamingworld.tournament.resource.CreateTournamentResource;
import com.gamingworld.app.gamingworld.tournament.resource.TournamentResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

public class ExternalAPIMapper {
    public ExternalAPI toModel(TwitchOAuthResponseResource resource) {
        ExternalAPI externalAPI = new ExternalAPI();
        externalAPI.setName("TWITCH_AUTH");

        Date today = new Date();
        Long dayInMilliseconds = 1000L * 60L * 60L * 24L;

        // We save one day before the real expire date just in case.
        Date date = new Date(today.getTime() + (resource.getExpires_in() * 1000) - dayInMilliseconds);

        externalAPI.setExpirationDate(date);

        externalAPI.setToken(resource.getAccess_token());

        return externalAPI;
    }
}
