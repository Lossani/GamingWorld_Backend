package com.gamingworld.app.gamingworld.profile.domain.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "streamer_sponsor")
public class StreamerSponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne()
    private Profile profile;

}
