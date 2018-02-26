package com.research.ml.dao;

import com.research.ml.model.ModelInfo;
import org.springframework.dao.DataAccessException;

public interface ModelInfoDao {

    /**
     * Retrieve an <code>ModelInfo</code> from the database by id.
     *
     * @param modelInfoId the id to search for
     * @return the <code>ModelInfo</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    ModelInfo findById(long modelInfoId) throws DataAccessException;
}
