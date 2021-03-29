package com.voitures.data.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author e.livaniaina
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehicleDTO {
	private Long id;
	private String model;
	private String brand;

	public VehicleDTO() {
	}

	public VehicleDTO(String model, String brand) {
		this.model = model;
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
