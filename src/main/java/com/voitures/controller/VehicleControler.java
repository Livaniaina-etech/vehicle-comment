package com.voitures.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voitures.data.dto.vehicle.VehicleListDTO;
import com.voitures.services.applicatif.vehicle.VehicleSA;

/**
 *
 * @author e.livaniaina
 */
@RestController
@RequestMapping(value = "/vehicle")
public class VehicleControler {

	@Autowired
	VehicleSA vehicleSA;

	@PreAuthorize("permitAll()")
	@CrossOrigin(origins = "*")
	@GetMapping("/list")
	public ResponseEntity<VehicleListDTO> getListVehicle(
			@ApiParam(name = "pageNo") @RequestParam(defaultValue = "0") Integer pageNo,
			@ApiParam(name = "pageSize") @RequestParam(defaultValue = "10") Integer pageSize)
			throws Exception {
		try {
			return new ResponseEntity<>(vehicleSA.getListVehicle(pageNo, pageSize, null), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new VehicleListDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
