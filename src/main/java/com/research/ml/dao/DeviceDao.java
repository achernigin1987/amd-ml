package com.research.ml.dao;

import com.research.ml.model.Device;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Set;

public interface DeviceDao {
    /**
     * Retrieve an <code>Device</code> from the database by id.
     *
     * @param deviceId the id to search for
     * @return the <code>Device</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Device findById(long deviceId) throws DataAccessException;

    /**
     * Retrieve an <code>Set<Device></code> from the database by id.
     *
     * @param deviceIds the set of id to search for
     * @return the <code>Set<Device></code> if found, empty set otherwise
     */
    Set<Device> findAllById(Set<Long> deviceIds);
}
