package com.gamingworld.app.gamingworld.user.domain.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gamingworld.app.gamingworld.shared.model.AuditModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile extends AuditModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter Long id;

    @OneToOne
    private @Getter @Setter User user;

    @OneToMany
    private @Getter @Setter List<GameExperience> gameExperiences;

    public Profile() {
    }

    public void addGameExperience(GameExperience entity){
        gameExperiences.add(entity);
    }
}
