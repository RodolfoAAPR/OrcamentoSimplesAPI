package com.orcamentomecanico.OrcamentoSimples.service;

import com.orcamentomecanico.OrcamentoSimples.model.ServiceModel;
import com.orcamentomecanico.OrcamentoSimples.repository.ServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceModel> findAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceModel findServiceById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service not found with id " + id));
    }

    public ServiceModel registerService(ServiceModel serviceModel) {
        return serviceRepository.save(serviceModel);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public ServiceModel updateService(Long id, ServiceModel serviceModel) {
        ServiceModel newService = serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service not found with id " + id));
        newService.setName(serviceModel.getName());
        newService.setDescription(serviceModel.getDescription());
        newService.setPrice(serviceModel.getPrice());
        return serviceRepository.save(newService);
    }
}
