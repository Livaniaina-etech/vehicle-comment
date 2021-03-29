/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voitures.services.applicatif.vehicle;

import com.voitures.data.dto.vehicle.VehicleDTO;
import com.voitures.data.dto.vehicle.VehicleListDTO;

/**
 *
 * @author e.livaniaina
 */
public interface VehicleSA {

	public void saveVehicle(VehicleDTO dto);

	public VehicleListDTO getListVehicle(Integer pageNo, Integer pageSize, String sortBy);
}
