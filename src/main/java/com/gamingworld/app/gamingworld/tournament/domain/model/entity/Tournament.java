package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;
import com.gamingworld.app.gamingworld.tournament.shared.model.AuditModel;
import com.gamingworld.app.gamingworld.user.domain.model.entity.User;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournament")
@Inheritance(strategy = InheritanceType.JOINED)

public class Tournament extends AuditModel{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    @Column
    private String title;

    @Column(length = 512)
    private String description;

    @Column(name = "prize_pool")
    private Integer prizePool;
}
