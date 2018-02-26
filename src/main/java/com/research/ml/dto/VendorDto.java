package com.research.ml.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.research.ml.model.Vendor;

@JsonPropertyOrder({"vendorId", "vendorName"})
public class VendorDto {

    private Integer vendorId;
    private String vendorName;

    public VendorDto(Vendor vendor) {
        this.vendorId = vendor.getId();
        this.vendorName = vendor.getName();
    }

    @JsonGetter("vendorId")
    public Integer getVendorId() {
        return vendorId;
    }

    @JsonGetter("vendorName")
    public String getVendorName() {
        return vendorName;
    }
}
