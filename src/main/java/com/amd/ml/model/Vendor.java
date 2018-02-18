package com.amd.ml.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vendor")
public class Vendor extends NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor-sequence-generator")
    @SequenceGenerator(name = "vendor-sequence-generator", sequenceName = "vendor_id_seq")
    private int id;

    @OneToMany(mappedBy="vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeviceType> deviceTypes = new HashSet<>();

    public Vendor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<DeviceType> getDeviceTypes() {
        return deviceTypes;
    }

    public void setDeviceTypes(Set<DeviceType> deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    public void addDeviceType(DeviceType deviceType) {
        deviceTypes.add(deviceType);
        deviceType.setVendor(this);
    }

    public void removeDeviceType(DeviceType deviceType) {
        deviceTypes.remove(deviceType);
        deviceType.setVendor(null);
    }

}
