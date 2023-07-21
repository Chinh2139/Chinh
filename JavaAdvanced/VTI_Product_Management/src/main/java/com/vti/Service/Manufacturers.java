package com.vti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.Entity.Manufacturer;
import com.vti.Repository.IManufacturerRepository;

@Service
public class Manufacturers implements IManufacturerService {
	@Autowired
	private IManufacturerRepository manufacturerRepository;

	@Override
	public List<Manufacturer> getAllManufacturers() {
		// TODO Auto-generated method stub
		return manufacturerRepository.findAll();
	}

	@Override
	public Manufacturer getManufacturerById(Short id) {
		// TODO Auto-generated method stub
		return manufacturerRepository.getById(id);
	}

}
