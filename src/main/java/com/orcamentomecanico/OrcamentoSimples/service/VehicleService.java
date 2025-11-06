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
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado com o ID " + id));
    }

    public VehicleModel registerVehicle(VehicleModel vehicleModel){
        if (vehicleModel.getProprietario() == null || vehicleModel.getProprietario().getId() == null) {
            throw new IllegalStateException("ID do Cliente não pode ser nulo");
        }
        CustomerModel customer = customerRepository.findById(vehicleModel.getProprietario().getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID " + vehicleModel.getProprietario().getId()));
        vehicleModel.setProprietario(customer);
        return vehicleRepository.save(vehicleModel);
    }

    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }

    public VehicleModel updateVehicle(Long id, VehicleModel vehicleModel){
        VehicleModel newVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado com o ID " + id));

        if (vehicleModel.getProprietario() != null && vehicleModel.getProprietario().getId() != null) {
            CustomerModel customer = customerRepository.findById(vehicleModel.getProprietario().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID " + vehicleModel.getProprietario().getId()));
            newVehicle.setProprietario(customer);
        }

        newVehicle.setCor(vehicleModel.getCor());
        newVehicle.setModelo(vehicleModel.getModelo());
        newVehicle.setAno(vehicleModel.getAno());
        newVehicle.setPlaca(vehicleModel.getPlaca());

        return vehicleRepository.save(newVehicle);
    }
}
