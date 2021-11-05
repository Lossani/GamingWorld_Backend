package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import java.util.List;

import javax.persistence.*;

import com.gamingworld.app.gamingworld.tournament.shared.model.AuditModel;
import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;

import lombok.*;

@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
@Inheritance(strategy = InheritanceType.JOINED)
public class Team extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull private String name;
    
    @Column
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(targetEntity = Profile.class)
    private Profile ownerProfile;

    @ManyToMany
    private List<Profile> members;

    @Column
    private Integer points = 0;
}
