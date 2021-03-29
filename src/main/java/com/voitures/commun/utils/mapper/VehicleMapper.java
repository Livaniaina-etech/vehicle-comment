package com.voitures.commun.utils.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.voitures.data.dto.vehicle.VehicleDTO;
import com.voitures.data.entity.Vehicle;

/**
 *
 * @author e.livaniaina
 */
@Mapper(componentModel = "spring")
public interface VehicleMapper {

	VehicleDTO vehicleToDto(Vehicle vehicle);

	Vehicle dtoToVehicle(VehicleDTO dto);

	List<VehicleDTO> vehiclesToDtos(List<Vehicle> vehicles);

}
