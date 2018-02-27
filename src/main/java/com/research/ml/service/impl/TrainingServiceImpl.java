package com.research.ml.service.impl;

import com.research.ml.dao.DeviceDao;
import com.research.ml.dao.ModelInfoDao;
import com.research.ml.dao.TrainingDao;
import com.research.ml.dao.UserDao;
import com.research.ml.dto.TrainingDto;
import com.research.ml.model.*;
import com.research.ml.service.TrainingService;
import com.research.ml.common.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {

    private UserDao userDao;
    private ModelInfoDao modelInfoDao;
    private DeviceDao deviceDao;
    private TrainingDao trainingDao;

    @Autowired
    public TrainingServiceImpl(
            UserDao userDao,
            ModelInfoDao modelInfoDao,
            DeviceDao deviceDao,
            TrainingDao trainingDao) {
        this.userDao = userDao;
        this.modelInfoDao = modelInfoDao;
        this.deviceDao = deviceDao;
        this.trainingDao = trainingDao;
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
        Set<Device> devices = deviceDao.findAllById(trainingDto.getDeviceIds());

        Training training = new Training();
        training.setModelInfo(modelInfo);
        training.setModelParams(trainingDto.getModelParams());
        training.setDevices(devices);
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
