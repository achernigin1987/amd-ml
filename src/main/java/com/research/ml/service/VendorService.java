package com.research.ml.service;

import com.research.ml.dto.VendorDeviceTypesDto;
import com.research.ml.dto.VendorDto;
import com.research.ml.model.DeviceType;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface VendorService {

    VendorDto findVendorById(int id) throws DataAccessException;

    List<VendorDto> findAllVendors();

    void createVendor(VendorDto vendor);

    void updateVendor(VendorDto vendor);

    VendorDeviceTypesDto findDeviceTypesByVendorId(int vendorId);

    void addDeviceType(int vendorId, DeviceType deviceType);
}

