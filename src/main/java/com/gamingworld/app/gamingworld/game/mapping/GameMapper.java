package com.gamingworld.app.gamingworld.game.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamingworld.app.gamingworld.externalapi.domain.model.entity.ExternalAPI;
import com.gamingworld.app.gamingworld.externalapi.resource.TwitchOAuthResponseResource;
import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;

import java.util.Date;

public class GameMapper {
    public Game toModel(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(jsonString, Game.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
