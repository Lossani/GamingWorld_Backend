package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import javax.persistence.*;

import com.gamingworld.app.gamingworld.tournament.shared.model.AuditModel;
import com.gamingworld.app.gamingworld.profile.domain.model.entity.Profile;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "participant")
@Inheritance(strategy = InheritanceType.JOINED)


public class Participant extends AuditModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull private Integer points;

    @OneToOne
    @NonNull private Profile participantProfile;

    private Long tournamentId;



}
