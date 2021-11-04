package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "solo_tournaments")
@PrimaryKeyJoinColumn(name = "tournament_id")
public class SoloTournament extends Tournament{
    
    @OneToMany
    private List<Participant> participants;

}
