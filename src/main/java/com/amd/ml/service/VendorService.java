package com.amd.ml.service;

import com.amd.ml.dto.VendorDeviceTypesDto;
import com.amd.ml.dto.VendorDto;
import com.amd.ml.model.DeviceType;
import com.amd.ml.model.Vendor;
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

