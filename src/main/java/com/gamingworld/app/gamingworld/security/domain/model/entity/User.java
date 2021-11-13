package com.gamingworld.app.gamingworld.security.domain.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    private boolean enable;

    @Column(length = 40, nullable = false)
    private String lastName;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Authority> authorities;

    public User() {
        this.enable = true;
        this.authorities = new ArrayList<>();
    }
    public User( String username, String password ) {
        this.username = username;
        this.password = password;
        this.enable = true;
        this.authorities = new ArrayList<>();
    }

    public void addAuthority( String _authority ) {
        Authority authority = new Authority();
        authority.setAuthority( _authority );
        authority.setUser(this);
        this.authorities.add(authority);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
