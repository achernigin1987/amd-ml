package com.amd.ml.dao.impl;

import com.amd.ml.dao.AbstractDao;
import com.amd.ml.dao.VendorDao;
import com.amd.ml.model.DeviceType;
import com.amd.ml.model.Vendor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class JPAVendorDao extends AbstractDao<Integer, Vendor> implements VendorDao {

    @Override
    public Vendor findById(int id) throws DataAccessException {
        return super.findById(id);
    }

    @Override
    public List<Vendor> findAll() {
        return super.findAll();
    }

    @Override
    public Set<DeviceType> findDeviceTypes(int vendorId) throws DataAccessException {
       return findById(vendorId).getDeviceTypes();
    }

    @Override
    public void saveVendor(Vendor vendor) {
        create(vendor);
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }
}
