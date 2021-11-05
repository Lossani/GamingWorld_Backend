package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import javax.persistence.*;

import com.gamingworld.app.gamingworld.game.domain.model.entity.Game;
import com.gamingworld.app.gamingworld.tournament.shared.model.AuditModel;
import com.gamingworld.app.gamingworld.user.domain.model.entity.User;

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

public class Tournament extends AuditModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    @Nullable
    @OneToMany(fetch = FetchType.LAZY)
    private List<Participant> participantList;

    @Column
    private String title;

    @Column(length = 512)
    private String description;

    @Column(name = "prize_pool")
    private Integer prizePool;
}
