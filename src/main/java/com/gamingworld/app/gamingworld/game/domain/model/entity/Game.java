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
@Entity
@Table(name = "game")
@NoArgsConstructor
@RequiredArgsConstructor
public class Game extends AuditModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    @NonNull private String title;

    @Column
    @NonNull private String description;

    @Column(name = "image_url")
    @NonNull private String imageUrl;
}
