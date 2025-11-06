package com.orcamentomecanico.OrcamentoSimples.service;

import com.orcamentomecanico.OrcamentoSimples.model.StaffModel;
import com.orcamentomecanico.OrcamentoSimples.repository.StaffRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public StaffModel findStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID " + id));
    }

    public StaffModel registerStaff(StaffModel staffModel){
        return staffRepository.save(staffModel);
    }

    public  void deleteStaff(Long id){
        staffRepository.deleteById(id);
    }

    public StaffModel updateStaff(Long id, StaffModel staffModel){
        StaffModel newStaff = staffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID " + id));
        newStaff.setNome(staffModel.getNome());
        newStaff.setCargo(staffModel.getCargo());
        return staffRepository.save(newStaff);
    }
}
