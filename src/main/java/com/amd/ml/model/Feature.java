package com.amd.ml.model;

import javax.persistence.*;

@Entity
@Table(name="feature")
public class Feature extends NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature-sequence-generator")
    @SequenceGenerator(name = "feature-sequence-generator", sequenceName = "feature_id_seq")
    private Long id;

    @Column(name = "path")
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
