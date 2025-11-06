package com.orcamentomecanico.OrcamentoSimples.controller;

import com.orcamentomecanico.OrcamentoSimples.model.CustomerModel;
import com.orcamentomecanico.OrcamentoSimples.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerModel> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerModel getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    public CustomerModel registerCustomer(@RequestBody CustomerModel customerModel) {
        return customerService.registerCustomer(customerModel);
    }

    @PutMapping("/{id}")
    public CustomerModel updateCustomer(@PathVariable Long id, @RequestBody CustomerModel customerModel) {
        return customerService.updateCustomer(id, customerModel);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
