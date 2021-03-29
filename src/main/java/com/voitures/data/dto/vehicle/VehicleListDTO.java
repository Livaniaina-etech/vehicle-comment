package com.voitures.data.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.voitures.data.dto.commun.BaseDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e.livaniaina
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehicleListDTO extends BaseDTO {

	List<VehicleDTO> data;

	public VehicleListDTO() {
		this.data = new ArrayList<>();
	}

	public VehicleListDTO(List<VehicleDTO> data) {
		this.data = data;
	}

	public List<VehicleDTO> getData() {
		return data;
	}

	public void setData(List<VehicleDTO> data) {
		this.data = data;
	}

}
