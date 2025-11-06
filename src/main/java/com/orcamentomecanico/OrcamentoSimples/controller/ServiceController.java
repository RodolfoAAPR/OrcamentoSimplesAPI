package com.orcamentomecanico.OrcamentoSimples.controller;

import com.orcamentomecanico.OrcamentoSimples.model.ServiceModel;
import com.orcamentomecanico.OrcamentoSimples.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<ServiceModel> getAllServices() {
        return serviceService.findAllServices();
    }

    @GetMapping("/{id}")
    public ServiceModel getServiceById(@PathVariable Long id) {
        return serviceService.findServiceById(id);
    }

    @PostMapping
    public ServiceModel registerService(@RequestBody ServiceModel serviceModel) {
        return serviceService.registerService(serviceModel);
    }

    @PutMapping("/{id}")
    public ServiceModel updateService(@PathVariable Long id, @RequestBody ServiceModel serviceModel) {
        return serviceService.updateService(id, serviceModel);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}
