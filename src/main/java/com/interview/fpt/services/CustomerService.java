package com.interview.fpt.services;

import com.interview.fpt.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> getAllCusstomers();
    public List<Customer> findCustomerByName(String name);
    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(Integer id);

}
