package com.vti.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.ManufacturerDto;
import com.vti.Entity.Manufacturer;
import com.vti.Service.ManufaturerService;

@RestController
@RequestMapping(value = "api/v3/manufacturer")
@CrossOrigin("*")
public class ManufucturerController {
	@Autowired
	private ManufaturerService manufacturerService;

	@GetMapping()
	public ResponseEntity<?> getAllManufacturers() {
		List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();

		List<ManufacturerDto> manufacturerDtos = new ArrayList<>();
		// chuyển đổi dữ liệu
		for (Manufacturer manufacturer : manufacturers) {
			ManufacturerDto manufacturerDto = new ManufacturerDto();
			manufacturerDto.setId(manufacturer.getId());
			manufacturerDto.setName(manufacturer.getName().toString());
			manufacturerDtos.add(manufacturerDto);
		}

		return new ResponseEntity<>(manufacturerDtos, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<?> getManufacturerById(@PathVariable(name = "id") Short id) {
		try {
			Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
			ManufacturerDto manufacturerDto = new ManufacturerDto();
			manufacturerDto.setId(manufacturer.getId());
			manufacturerDto.setName(manufacturer.getName().toString());
			return new ResponseEntity<>(manufacturerDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}
	}
}
