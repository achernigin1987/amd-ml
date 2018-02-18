package com.amd.ml.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User extends NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user-sequence-generator")
    @SequenceGenerator(name = "user-sequence-generator", sequenceName = "user_id_seq")
    private Long id;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Training> trainings = new HashSet<>();

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void addTraining(Training training) {
        trainings.add(training);
        training.setUser(this);
    }

    public void removeTraining(Training training) {
        trainings.remove(training);
        training.setUser(null);
    }
}
