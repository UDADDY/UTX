package com.midsangam.utx.controller;

import com.midsangam.utx.entity.Customer;
import com.midsangam.utx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CusomteController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String create(@RequestBody Customer customer){
        if(!customerService.create(customer))
            return "Create Failed";
        return "Create Success";
    }

    @GetMapping("{customerId}")
    public Customer read(@PathVariable int customerId){
        Customer customer = customerService.readById(customerId);
        if(customer==null)
            return null;
        return customer;
    }

    @PutMapping
    public void update(@RequestBody Customer customer){
        customerService.update(customer);
    }

    @DeleteMapping("{customerId}")
    public void delete(@PathVariable int customerId){
        customerService.delete(customerId);
    }

}
