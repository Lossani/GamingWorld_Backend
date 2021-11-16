package com.gamingworld.app.gamingworld.profile.domain.model.entity;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "favourite_games")
@NoArgsConstructor

public class FavouriteGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Game.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

}

