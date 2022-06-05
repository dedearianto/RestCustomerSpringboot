package com.interview.fpt.controllers;

import com.interview.fpt.exceptions.CustomerException;
import com.interview.fpt.models.Customer;
import com.interview.fpt.models.HelloWorld;
import com.interview.fpt.repository.CustomerRepository;
import com.interview.fpt.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository repository;

    @GetMapping(path = "/hello-world")
    public HelloWorld helloWorld()
    {
        return new HelloWorld("Hello World Rest API");
    }

    @GetMapping(path = "/find-all-customer")
    public List<Customer> findAllCustomer(){
        List<Customer> result =service.getAllCusstomers();
        if(result == null){
         throw  new CustomerException("AllCustomer Data not found");
        }
        return result;
    }

    @PostMapping(value="/create-customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) throws Exception{
        Customer customerSaved = service.saveCustomer(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customerSaved.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PostMapping(value="/update-customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) throws Exception{
        Customer customerUpdated = service.updateCustomer(customer);
        if(customerUpdated==null){
            throw new CustomerException("id: " +customer.getId());
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customerUpdated.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value="/get-customer/{name}")
    public List<Customer> findCustomerByName(@PathVariable String name){
        return service.findCustomerByName(name);
    }

    @DeleteMapping(value="/delete-customer/{id}")
    public void deleteCustomerById(@PathVariable int id){
        Optional<Customer> customerDeleted = repository.findById(id);
        if(customerDeleted.isPresent()){
            service.deleteCustomer(id);
        }else{
            throw new CustomerException("id not found to be deleted :" +id);
        }
    }


}


