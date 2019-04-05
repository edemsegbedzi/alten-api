package com.alten.challenge.api.dto;

import com.alten.challenge.api.model.Customer;
import com.alten.challenge.api.model.Vehicle;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CustomerDto{


    Long id;
    String name,address;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    List<Vehicle> vehicles;

    public CustomerDto(Customer customer ,List<Vehicle> vehicles) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.createDateTime = customer.getCreateDateTime();
        this.updateDateTime = customer.getUpdateDateTime();
        this.vehicles = vehicles;
    }

}
