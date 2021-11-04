package com.gamingworld.app.gamingworld.tournament.resource;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentResource {
    private Long id;
    private String title;
    private String description;
    private Number prizePool;
}
