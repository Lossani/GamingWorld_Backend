package com.gamingworld.app.gamingworld.profile.domain.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.stream.Stream;

@Getter
@Setter
@Entity
@Table(name = "streamer_sponsors")
public class StreamerSponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne()
    private Profile profile;

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof StreamerSponsor))
            return false;
        StreamerSponsor streamerSponsor = (StreamerSponsor) obj;
        return streamerSponsor.id.equals(id);
    }
}
