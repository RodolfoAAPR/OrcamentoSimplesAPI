package com.orcamentomecanico.OrcamentoSimples.controller;

import com.orcamentomecanico.OrcamentoSimples.model.VehicleModel;
import com.orcamentomecanico.OrcamentoSimples.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<VehicleModel> getAllVehicles() {
        return vehicleService.findAllVehicles();
    }

    @GetMapping("/{id}")
    public VehicleModel getVehicleById(@PathVariable Long id) {
        return vehicleService.findVehicleById(id);
    }

    @PostMapping
    public VehicleModel registerVehicle(@RequestBody VehicleModel vehicleModel) {
        return vehicleService.registerVehicle(vehicleModel);
    }

    @PutMapping("/{id}")
    public VehicleModel updateVehicle(@PathVariable Long id, @RequestBody VehicleModel vehicleModel) {
        return vehicleService.updateVehicle(id, vehicleModel);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}
