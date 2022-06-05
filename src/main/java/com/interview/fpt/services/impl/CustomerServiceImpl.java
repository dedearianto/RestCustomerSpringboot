package com.interview.fpt.services.impl;

import com.interview.fpt.models.Customer;
import com.interview.fpt.repository.CustomerRepository;
import com.interview.fpt.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> getAllCusstomers() {
        return repository.findAll();
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return repository.findbyName(name);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> updateCustomer = repository.findById(customer.getId());
        if(updateCustomer.isPresent()){
            updateCustomer.get().setName(customer.getName());
            updateCustomer.get().setAddress(customer.getAddress());
            repository.save(updateCustomer.get());
            return updateCustomer.get();
        }
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {
       repository.deleteById(id);
    }
}
