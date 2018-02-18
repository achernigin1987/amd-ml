package com.amd.ml.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="model_info")
public class ModelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model-info-sequence-generator")
    @SequenceGenerator(name = "model-info-sequence-generator", sequenceName = "model_info_id_seq")
    private Long id;

    @OneToMany(mappedBy="modelInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Training> trainings = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "model_info_feature",
            joinColumns = @JoinColumn(name = "model_info_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> features;

    @Column(name = "source_code_path")
    private String sourceCodePath;

    @Column(name = "parameters")
    private String parameters;

    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCodePath() {
        return sourceCodePath;
    }

    public void setSourceCodePath(String sourceCodePath) {
        this.sourceCodePath = sourceCodePath;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFeaturesCount() {
        return getFeaturesInternal().size();
    }

    public void addFeature(Feature feature) {
        getFeaturesInternal().add(feature);
    }

    protected Set<Feature> getFeaturesInternal() {
        if (this.features == null) {
            this.features = new HashSet<>();
        }
        return this.features;
    }

    protected void setFeaturesInternal(Set<Feature> features) {
        this.features = features;
    }

}
