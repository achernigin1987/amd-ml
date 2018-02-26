package com.research.ml.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device-sequence-generator")
    @SequenceGenerator(name = "device-sequence-generator", sequenceName = "device_id_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;

    private String location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device )) return false;

        return id != null && id.equals(((Device) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
