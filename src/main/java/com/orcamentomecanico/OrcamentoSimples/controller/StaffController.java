package com.orcamentomecanico.OrcamentoSimples.controller;

import com.orcamentomecanico.OrcamentoSimples.model.StaffModel;
import com.orcamentomecanico.OrcamentoSimples.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public List<StaffModel> getAllStaffs() {
        return staffService.findAllStaffs();
    }

    @GetMapping("/{id}")
    public StaffModel getStaffById(@PathVariable Long id) {
        return staffService.findStaffById(id);
    }

    @PostMapping
    public StaffModel registerStaff(@RequestBody StaffModel staffModel) {
        return staffService.registerStaff(staffModel);
    }

    @PutMapping("/{id}")
    public StaffModel updateStaff(@PathVariable Long id, @RequestBody StaffModel staffModel) {
        return staffService.updateStaff(id, staffModel);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }
}
