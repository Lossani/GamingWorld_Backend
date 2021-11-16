package com.gamingworld.app.gamingworld.profile.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tournament_experiences")
public class TournamnetExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer position;

    @ManyToOne()
    private Profile profile;

}
