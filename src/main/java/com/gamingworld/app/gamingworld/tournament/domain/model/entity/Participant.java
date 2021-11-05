package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gamingworld.app.gamingworld.tournament.shared.model.AuditModel;
import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;

import lombok.*;

import java.io.Serializable;
import java.util.List;

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
