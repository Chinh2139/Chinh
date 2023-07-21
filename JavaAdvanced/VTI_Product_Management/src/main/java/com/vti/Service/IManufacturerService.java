package com.vti.Service;

import java.util.List;

import com.vti.Entity.Manufacturer;

public interface IManufacturerService {

	public List<Manufacturer> getAllManufacturers();

	public Manufacturer getManufacturerById(Short id);

}
