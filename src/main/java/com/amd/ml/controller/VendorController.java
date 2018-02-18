package com.amd.ml.controller;

import com.amd.ml.dto.VendorDto;
import com.amd.ml.model.Vendor;
import com.amd.ml.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/vendors")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VendorDto> findAllVendors() {

        return vendorService.findAllVendors();
    }

    @GetMapping(path = "/{vendorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VendorDto findVendorById(int vendorId) {
        return vendorService.findVendorById(vendorId);
    }
}
