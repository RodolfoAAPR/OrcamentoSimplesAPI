package com.orcamentomecanico.OrcamentoSimples.service;

import com.orcamentomecanico.OrcamentoSimples.model.CustomerModel;
import com.orcamentomecanico.OrcamentoSimples.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerModel> findAllCustomers(){
        return customerRepository.findAll();
    }

    public CustomerModel findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));
    }

    public CustomerModel registerCustomer(CustomerModel customerModel){
        return customerRepository.save(customerModel);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public CustomerModel updateCustomer(Long id, CustomerModel customerModel){
        CustomerModel newCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));
        newCustomer.setCpf(customerModel.getCpf());
        newCustomer.setName(customerModel.getName());
        newCustomer.setEmail(customerModel.getEmail());
        newCustomer.setNumber(customerModel.getNumber());
        return customerRepository.save(newCustomer);
    }
}
