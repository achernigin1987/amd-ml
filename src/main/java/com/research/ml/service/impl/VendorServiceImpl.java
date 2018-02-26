package com.research.ml.service.impl;

import com.research.ml.dao.VendorDao;
import com.research.ml.dto.VendorDeviceTypesDto;
import com.research.ml.dto.VendorDto;
import com.research.ml.model.DeviceType;
import com.research.ml.model.Vendor;
import com.research.ml.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        List<Vendor> vendors = vendorDao.findAll();
        return vendors.stream().map(VendorDto::new).collect(Collectors.toList());
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
