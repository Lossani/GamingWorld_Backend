package com.gamingworld.app.gamingworld.tournament.domain.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gamingworld.app.gamingworld.tournament.shared.model.AuditModel;
import com.gamingworld.app.gamingworld.user.domain.model.entity.Profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Team extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull private String title;
    
    @Column
    @NonNull private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
    private Profile ownerProfile;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Profile> members;

    @Column
    private Integer points = 0;
}
