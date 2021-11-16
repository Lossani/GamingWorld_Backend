package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import javax.persistence.*;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;
import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import com.gamingworld.app.gamingworld.tournament.shared.model.AuditModel;

import lombok.*;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournament")
@Inheritance(strategy = InheritanceType.JOINED)

public class Tournament extends AuditModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    private User user;

    @OneToOne()
    private Game game;

    @Nullable
    @OneToMany()
    @JoinColumn(name="participant_id", referencedColumnName="id")
    private List<Participant> participantList;

    @Nullable
    @OneToMany()
    private List<Team> teamList;

    @Column
    private String title;

    @NonNull
    @Column
    private Boolean isTeamMode;

    @Column(length = 512)
    private String description;

    @Column(name = "prize_pool")
    private Integer prizePool;
}
