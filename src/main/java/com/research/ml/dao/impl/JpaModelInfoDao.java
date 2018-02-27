package com.research.ml.dao.impl;

import com.research.ml.dao.AbstractDao;
import com.research.ml.dao.ModelInfoDao;
import com.research.ml.model.ModelInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaModelInfoDao extends AbstractDao<Long, ModelInfo> implements ModelInfoDao {

    @Override
    public ModelInfo findById(long modelInfoId) throws DataAccessException {
        return super.findById(modelInfoId);
    }
}
