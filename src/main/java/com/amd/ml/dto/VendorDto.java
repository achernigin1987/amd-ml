package com.amd.ml.dto;

import com.amd.ml.model.Vendor;

public class VendorDto {

    private Integer vendorId;
    private String vendorName;

    public VendorDto(Vendor vendor) {
        this.vendorId = vendor.getId();
        this.vendorName = vendor.getName();
    }
}
