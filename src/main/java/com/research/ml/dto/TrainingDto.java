package com.research.ml.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.research.ml.model.Training;
import com.research.ml.model.TrainingStatus;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "trainingId", "modelInfoId", "modelParams",
        "createdAt", "startedAt", "finishedAt",
        "status", "userId", "description"
})
public class TrainingDto {
    private Long trainingId;
    private Long modelInfoId;
    private String modelParams;
    private Long createdAt;
    private Long startedAt;
    private Long finishedAt;
    private TrainingStatus status;
    private Long userId;
    private String description;

    public TrainingDto() {}

    public TrainingDto(Training training) {
        this.trainingId = training.getId();
        this.modelInfoId = training.getModelInfo().getId();
        this.modelParams = training.getModelParams();
        this.createdAt = training.getCreatedAt().getTime();
        this.startedAt = training.getStartedAt().getTime();
        this.finishedAt = training.getFinishedAt().getTime();
        this.status = training.getStatus();
        this.userId = training.getUser().getId();
        this.description = training.getDescription();
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Long getModelInfoId() {
        return modelInfoId;
    }

    public void setModelInfoId(Long modelInfoId) {
        this.modelInfoId = modelInfoId;
    }

    public String getModelParams() {
        return modelParams;
    }

    public void setModelParams(String modelParams) {
        this.modelParams = modelParams;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Long startedAt) {
        this.startedAt = startedAt;
    }

    public Long getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Long finishedAt) {
        this.finishedAt = finishedAt;
    }

    public TrainingStatus getStatus() {
        return status;
    }

    public void setStatus(TrainingStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
