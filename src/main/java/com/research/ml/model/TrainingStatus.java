package com.research.ml.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.research.ml.util.ConvertTo;

public enum TrainingStatus {
    DRAFT(1, "DRAFT"),
    IN_PROGRESS(2, "IN_PROGRESS"),
    FINISHED(3, "FINISHED"),
    CANCELED(4, "CANCELED"),
    FAILED(5, "FAILED");

    private Integer id;
    private String name;

    TrainingStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TrainingStatus withName(String name) {
        return ConvertTo.stream(values())
                .filter(s -> s.name.equals(name))
                .findFirst().orElse(null);
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
