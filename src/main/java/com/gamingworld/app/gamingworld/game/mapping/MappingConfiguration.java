package com.gamingworld.app.gamingworld.game.mapping;

import com.gamingworld.app.gamingworld.externalapi.mapping.TwitchOAuthResponseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("gameMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public GameMapper gameMapper(){ return new GameMapper(); }
}
