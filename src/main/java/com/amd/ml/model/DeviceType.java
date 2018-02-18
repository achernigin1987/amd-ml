package com.amd.ml.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="device_type")
public class DeviceType extends NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device-type-sequence-generator")
    @SequenceGenerator(name = "device-type-sequence-generator", sequenceName = "device_type_id_seq")
    private Integer id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @OneToMany(mappedBy="deviceType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Device> devices = new HashSet<>();

    public DeviceType() { }

    public void addDevice(Device device) {
        devices.add(device);
        device.setDeviceType(this);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
        device.setDeviceType(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceType )) return false;

        return id != null && id.equals(((DeviceType) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
