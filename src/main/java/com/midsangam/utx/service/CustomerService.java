package com.midsangam.utx.service;

import com.midsangam.utx.entity.Customer;
import com.midsangam.utx.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean create(Customer customer) {
        customerRepository.save(customer);

        return true;
    }

    public Customer readById(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(!customerOptional.isPresent())
            return null;
        Customer customer = customerOptional.get();
        return customer;
    }

    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(int cusomterId) {
        customerRepository.deleteById(cusomterId);
    }

}
