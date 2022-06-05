package com.interview.fpt.bootstrap;

import com.interview.fpt.models.Customer;
import com.interview.fpt.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private CustomerService customerService;

    public DatabaseLoader(CustomerService customerService){
        this.customerService = customerService;
    }


    @Override
    public void run(String... args) throws Exception {

        addBoostrapCustomer();

    }

    private void addBoostrapCustomer(){

        List<Customer> data = new ArrayList<>();
        String dataCustomer[][]={{"dede arianto", "jalan 1"},{"nama 2", "jalan 2"},{"tech", "Jl. sudirman"} };
        for(int i=0;i<dataCustomer.length;i++){
            Customer addCustomer = new Customer();
            addCustomer.setName(dataCustomer[i][0]);
            addCustomer.setAddress(dataCustomer[i][1]);
            data.add(addCustomer);
        }
        //add data to db
        for (int x=0;x<data.size();x++){
            customerService.saveCustomer(data.get(x));
        }



    }

}
