package com.amd.ml.service.impl;

import com.amd.ml.dao.VendorDao;
import com.amd.ml.dto.VendorDeviceTypesDto;
import com.amd.ml.dto.VendorDto;
import com.amd.ml.model.DeviceType;
import com.amd.ml.model.Vendor;
import com.amd.ml.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorDao vendorDao;

    @Autowired
    public VendorServiceImpl(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }

    @Override
    @Transactional(readOnly = true)
    public VendorDto findVendorById(int id) throws DataAccessException {
        return new VendorDto(vendorDao.findById(id));
    }

    @Override
    public List<VendorDto> findAllVendors() {
        return vendorDao.findAll().stream().map(VendorDto::new).collect(Collectors.toList());
    }

    @Override
    public void createVendor(VendorDto vendor) {

    }

    @Override
    public void updateVendor(VendorDto vendor) {

    }

    @Override
    public VendorDeviceTypesDto findDeviceTypesByVendorId(int vendorId) {
        Vendor vendor = vendorDao.findById(vendorId);
        return new VendorDeviceTypesDto(vendor);
    }

    @Override
    public void addDeviceType(int vendorId, DeviceType deviceType) {
        Vendor vendor = vendorDao.findById(vendorId);
        vendor.addDeviceType(deviceType);
    }
}
