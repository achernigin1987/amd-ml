package com.research.ml.service;

import com.research.ml.dto.TrainingDto;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface TrainingService {

    TrainingDto findTrainingById(Long trainingId) throws DataAccessException;

    List<TrainingDto> findAllTrainings();

    TrainingDto createTraining(TrainingDto trainingDto);

    void startTrainingById(Long trainingId);

    void cancelTrainingById(Long trainingId);
}
