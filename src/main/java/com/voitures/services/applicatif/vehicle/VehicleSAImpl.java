package com.voitures.services.applicatif.vehicle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.voitures.commun.utils.mapper.VehicleMapper;
import com.voitures.data.dto.vehicle.VehicleDTO;
import com.voitures.data.dto.vehicle.VehicleListDTO;
import com.voitures.data.entity.Vehicle;
import com.voitures.services.repository.VehicleRepository;

/**
 *
 * @author e.livaniaina
 */
@Service
public class VehicleSAImpl implements VehicleSA {

	@Autowired
	VehicleRepository vehicleRepository;
	@Autowired
	VehicleMapper vehicleMapper;

	@PostConstruct
	public void init() {
		importDefaultVehicle();
	}

	public void importDefaultVehicle() {
		List<VehicleDTO> vehicles = new ArrayList<>();
		vehicles.add(new VehicleDTO("Focus", "Ford"));
		vehicles.add(new VehicleDTO("Impala", "Chevy"));
		vehicles.add(new VehicleDTO("Quatro", "Audi"));
		for (VehicleDTO vehicle : vehicles) {
			saveVehicle(vehicle);
		}
	}

	@Override
	public void saveVehicle(VehicleDTO dto) {
		Vehicle vehicle = vehicleRepository.findByModel(dto.getModel());
		if (vehicle == null) {
			vehicle = new Vehicle();
		} else {
			dto.setId(vehicle.getId());
		}
		vehicle = vehicleMapper.dtoToVehicle(dto);
		vehicleRepository.save(vehicle);
	}

	@Override
	public VehicleListDTO getListVehicle(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging;
		if (StringUtils.isEmpty(sortBy)) {
			sortBy = "id";
		}
		paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		Page<Vehicle> vehiclesPaged = vehicleRepository.findAll(paging);
		if (vehiclesPaged.hasContent()) {
			return new VehicleListDTO(vehicleMapper.vehiclesToDtos(vehiclesPaged.getContent()));
		} else {
			return new VehicleListDTO();
		}
	}
}
