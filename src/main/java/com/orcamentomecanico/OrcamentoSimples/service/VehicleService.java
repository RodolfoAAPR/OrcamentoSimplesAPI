package com.orcamentomecanico.OrcamentoSimples.service;

import com.orcamentomecanico.OrcamentoSimples.model.CustomerModel;
import com.orcamentomecanico.OrcamentoSimples.model.VehicleModel;
import com.orcamentomecanico.OrcamentoSimples.repository.CustomerRepository;
import com.orcamentomecanico.OrcamentoSimples.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<VehicleModel> findAllVehicles(){
        return vehicleRepository.findAll();
    }

    public VehicleModel findVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id " + id));
    }

    public VehicleModel registerVehicle(VehicleModel vehicleModel){
        if (vehicleModel.getOwner() == null || vehicleModel.getOwner().getId() == null) {
            throw new IllegalStateException("Customer ID cannot be null");
        }
        CustomerModel customer = customerRepository.findById(vehicleModel.getOwner().getId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + vehicleModel.getOwner().getId()));
        vehicleModel.setOwner(customer);
        return vehicleRepository.save(vehicleModel);
    }

    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }

    public VehicleModel updateVehicle(Long id, VehicleModel vehicleModel){
        VehicleModel newVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id " + id));

        if (vehicleModel.getOwner() != null && vehicleModel.getOwner().getId() != null) {
            CustomerModel customer = customerRepository.findById(vehicleModel.getOwner().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + vehicleModel.getOwner().getId()));
            newVehicle.setOwner(customer);
        }

        newVehicle.setColor(vehicleModel.getColor());
        newVehicle.setModel(vehicleModel.getModel());
        newVehicle.setYear(vehicleModel.getYear());
        newVehicle.setRegistration(vehicleModel.getRegistration());

        return vehicleRepository.save(newVehicle);
    }
}
