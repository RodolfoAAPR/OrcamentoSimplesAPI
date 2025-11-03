package com.orcamentomecanico.OrcamentoSimples.service;

import com.orcamentomecanico.OrcamentoSimples.model.VehicleModel;
import com.orcamentomecanico.OrcamentoSimples.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleModel> findAllVehicles(){
        return vehicleRepository.findAll();
    }

    public VehicleModel registerVehicle(VehicleModel vehicleModel){
        return vehicleRepository.save(vehicleModel);
    }

    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }

    public VehicleModel updateVehicle(Long id, VehicleModel vehicleModel){
        VehicleModel newVehicle = vehicleRepository.findById(id).get();
        newVehicle.setColor(newVehicle.getColor());
        newVehicle.setModel(newVehicle.getModel());
        newVehicle.setYear(newVehicle.getYear());
        newVehicle.setOwner(newVehicle.getOwner());
        newVehicle.setRegistration(newVehicle.getRegistration());

        return vehicleRepository.save(newVehicle);
    }
}
