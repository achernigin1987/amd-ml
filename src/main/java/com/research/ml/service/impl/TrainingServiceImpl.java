package com.research.ml.service.impl;

import com.research.ml.dao.ModelInfoDao;
import com.research.ml.dao.TrainingDao;
import com.research.ml.dao.UserDao;
import com.research.ml.dto.TrainingDto;
import com.research.ml.model.ModelInfo;
import com.research.ml.model.Training;
import com.research.ml.model.TrainingStatus;
import com.research.ml.model.User;
import com.research.ml.service.TrainingService;
import com.research.ml.common.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {

    private UserDao userDao;
    private TrainingDao trainingDao;
    private ModelInfoDao modelInfoDao;

    @Autowired
    public TrainingServiceImpl(
            UserDao userDao,
            TrainingDao trainingDao,
            ModelInfoDao modelInfoDao) {
        this.userDao = userDao;
        this.trainingDao = trainingDao;
        this.modelInfoDao = modelInfoDao;
    }

    @Override
    public TrainingDto findTrainingById(Long trainingId) throws DataAccessException {
        return new TrainingDto(trainingDao.findById(trainingId));
    }

    @Override
    public List<TrainingDto> findAllTrainings() {
        return trainingDao.findAll().stream().map(TrainingDto::new).collect(Collectors.toList());
    }

    @Override
    public TrainingDto createTraining(TrainingDto trainingDto) {
        User user = userDao.findById(trainingDto.getUserId());
        ModelInfo modelInfo = modelInfoDao.findById(trainingDto.getModelInfoId());

        Training training = new Training();
        training.setModelInfo(modelInfo);
        training.setModelParams(trainingDto.getModelParams());
        //training.setDevices();
        training.setUser(user);
        training.setCreatedAt(new java.sql.Timestamp(DateTimeUtil.nowUtcTs()));
        training.setStatus(TrainingStatus.DRAFT);
        training.setDescription(trainingDto.getDescription());

        trainingDao.createTraining(training);

        return new TrainingDto(training);
    }

    @Override
    public void startTrainingById(Long trainingId) {

    }

    @Override
    public void cancelTrainingById(Long trainingId) {

    }
}
