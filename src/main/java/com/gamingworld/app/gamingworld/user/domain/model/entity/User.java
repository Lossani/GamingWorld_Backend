package com.gamingworld.app.gamingworld.user.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gamingworld.app.gamingworld.shared.model.AuditModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends AuditModel{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @NonNull private String username;

    @Column(nullable = false, unique = true)
    @NonNull private String email;

    @Column(nullable = false)
    @NonNull private String password;

    @Column
    private Boolean premium = false;
}
