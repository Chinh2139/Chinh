package com.vti.Service;

import java.util.List;

import com.vti.Entity.Manufacturer;

public interface IManufacturerService {

	List<Manufacturer> getAllManufacturers();

	Manufacturer getManufacturerById(Short id);

}
