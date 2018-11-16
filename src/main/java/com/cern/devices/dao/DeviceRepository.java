package com.cern.devices.dao;

import com.cern.devices.entity.Device;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findDevicesById(Long id);
}
