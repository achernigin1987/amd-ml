package com.amd.ml.dto;

import com.amd.ml.model.DeviceType;
import com.amd.ml.model.Vendor;

import java.util.Set;

public class VendorDeviceTypesDto {
    private Integer vendorId;
    private String vendorName;
    private Set<DeviceType> deviceTypes;

    public VendorDeviceTypesDto(Vendor vendor) {
        this.vendorId = vendor.getId();
        this.vendorName = vendor.getName();
        this.deviceTypes = vendor.getDeviceTypes();
    }
}
