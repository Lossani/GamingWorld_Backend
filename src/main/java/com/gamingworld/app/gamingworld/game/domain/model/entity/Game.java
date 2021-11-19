package com.gamingworld.app.gamingworld.game.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gamingworld.app.gamingworld.shared.model.AuditModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Game{

    @NonNull private Long id;

    @NonNull private String name;

    private GameCover cover;
}

