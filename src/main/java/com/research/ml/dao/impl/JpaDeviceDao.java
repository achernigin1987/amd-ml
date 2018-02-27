package com.research.ml.dao.impl;

import com.research.ml.dao.AbstractDao;
import com.research.ml.dao.DeviceDao;
import com.research.ml.model.Device;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class JpaDeviceDao extends AbstractDao<Long, Device> implements DeviceDao {
    @Override
    public Device findById(long deviceId) throws DataAccessException {
        return super.findById(deviceId);
    }

    @Override
    public Set<Device> findAllById(Set<Long> deviceIds) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> query = builder.createQuery(persistentClass);
        Root<Device> root = query.from(persistentClass);
        query.select(root).where(root.get("id").in(deviceIds));

        List<Device> devices = entityManager.createQuery(query).getResultList();
        return new HashSet(devices);
    }
}
