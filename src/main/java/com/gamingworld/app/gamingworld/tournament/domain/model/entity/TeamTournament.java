package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "team_tournaments")
@PrimaryKeyJoinColumn(name = "tournament_id")
public class TeamTournament extends Tournament{
    
    @OneToMany
    private List<Team> teams;
}
