package com.vti.controller;

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

import com.vti.dto.PositionDto;
import com.vti.entity.Position;
import com.vti.service.IPositionService;

@RestController
@RequestMapping(value = "ap1/v1/position")
@CrossOrigin("*")
public class PositionController {
	@Autowired
	private IPositionService positionservice;

	@GetMapping()
	public ResponseEntity<?> GetAllPosition() {
		List<Position> positions = positionservice.GetAllPosition();
		List<PositionDto> positionDtos = new ArrayList<PositionDto>();
		for (Position position : positions) {
//			PositionDto positionDto = new PositionDto(position.getId(), position.getName().toString());
			PositionDto positionDto = new PositionDto();
			positionDto.setId(position.getId());
			positionDto.setName(position.getName().toString());
			positionDtos.add(positionDto);
		}

		return new ResponseEntity<>(positionDtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{idPosition}")
	public ResponseEntity<?> getPositionByID(@PathVariable(name = "idPosition") short id) {
		Position position = positionservice.getPositionByID();
		PositionDto positionDto = new PositionDto();
		positionDto.setId(position.getId());
		positionDto.setName(position.getName().toString());
		return new ResponseEntity<>(position, HttpStatus.OK);
	}
}
