package com.vti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.Entity.Manufacturer;

public interface IManufacturerRepository extends JpaRepository<Manufacturer, Short> {

}
