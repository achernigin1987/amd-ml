package com.research.ml.dao;

import com.research.ml.model.Training;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface TrainingDao {
    /**
     * Retrieve an <code>Training</code> from the database by id.
     *
     * @param trainingId the id to search for
     * @return the <code>Vendor</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Training findById(long trainingId) throws DataAccessException;

    List<Training> findAll();

    void saveTraining(Training training);

    void createTraining(Training training);

    void updateTraining(Training training);

    void deleteById(long trainingId);
}
