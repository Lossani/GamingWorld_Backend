package com.gamingworld.app.gamingworld.profile.domain.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "favorite_games")
@NoArgsConstructor

public class FavoriteGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(targetEntity = Game.class, fetch = FetchType.LAZY)
    //@JoinColumn(name = "game_id")
    private String game;

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof FavoriteGame))
            return false;
        FavoriteGame favoriteGame = (FavoriteGame) obj;
        return favoriteGame.id.equals(id);
    }
}

