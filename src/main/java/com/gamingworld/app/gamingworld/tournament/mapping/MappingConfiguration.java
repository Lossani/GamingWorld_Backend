package com.gamingworld.app.gamingworld.tournament.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("tournamentMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public TournamentMapper tournamentMapper(){ return new TournamentMapper(); }
    @Bean
    public ParticipantMapper participantMapper(){ return new ParticipantMapper(); }

}
