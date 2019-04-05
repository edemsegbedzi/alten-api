package com.alten.challenge.api.service;

import com.alten.challenge.api.dto.CustomerDto;
import com.alten.challenge.api.model.Customer;
import com.alten.challenge.api.model.Vehicle;
import com.alten.challenge.api.repo.CustomerRepo;
import com.alten.challenge.api.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class MainService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    public List<Customer> getCustomers(Long id) {
        if(id == null){
           return customerRepo.findAll();

        }else{
            return Arrays.asList(customerRepo.findById(id).orElse(null));
        }
    }

    public List<Vehicle> getVehicles(Long id) {
        if(id == null){
            return vehicleRepo.findAll();
        }else{
            return Arrays.asList(vehicleRepo.findById(id).orElse(null));
        }    }
}
