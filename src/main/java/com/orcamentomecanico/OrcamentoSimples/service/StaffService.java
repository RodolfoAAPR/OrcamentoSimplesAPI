package com.orcamentomecanico.OrcamentoSimples.service;

import com.orcamentomecanico.OrcamentoSimples.model.StaffModel;
import com.orcamentomecanico.OrcamentoSimples.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<StaffModel> findAllStaffs(){
        return staffRepository.findAll();
    }

    public StaffModel registerStaff(StaffModel staffModel){
        return staffRepository.save(staffModel);
    }

    public  void deleteStaff(Long id){
        staffRepository.deleteById(id);
    }

    public StaffModel updateStaff(Long id, StaffModel staffModel){
        StaffModel newStaff = staffRepository.findById(id).get();
        newStaff.setName(staffModel.getName());
        newStaff.setRole(staffModel.getRole());
        return staffRepository.save(newStaff);
    }
}
