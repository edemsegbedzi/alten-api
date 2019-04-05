package com.alten.challenge.api.controller;


import com.alten.challenge.api.dto.CustomerDto;
import com.alten.challenge.api.model.Customer;
import com.alten.challenge.api.model.Vehicle;
import com.alten.challenge.api.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class MainController {

    @Autowired
    MainService service;

    @GetMapping({"/customers","/customer"})
    public List<Customer> getCustomers(@RequestParam(required = false) Long id){return  service.getCustomers(id);}

    @GetMapping(value = {"/vehicles","/vehicle"})
    public List<Vehicle> getVehicles(@RequestParam(required = false) Long id){return  service.getVehicles(id);}


}
