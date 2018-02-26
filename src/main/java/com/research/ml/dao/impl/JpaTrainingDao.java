package com.research.ml.dao.impl;

import com.research.ml.dao.AbstractDao;
import com.research.ml.dao.TrainingDao;
import com.research.ml.model.Training;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class JpaTrainingDao extends AbstractDao<Long, Training> implements TrainingDao {

    @Override
    public Training findById(long trainingId) throws DataAccessException {
        return super.findById(trainingId);
    }

    @Override
    public void saveTraining(Training training) {
       if (training.getId() == null) {
           super.create(training);
       } else {
           super.update(training);
       }
    }

    @Override
    public void createTraining(Training training) {
        super.create(training);
    }

    @Override
    public void updateTraining(Training training) {
        super.update(training);
    }

    @Override
    public void deleteById(long trainingId) {
        super.deleteById(trainingId);
    }
}
