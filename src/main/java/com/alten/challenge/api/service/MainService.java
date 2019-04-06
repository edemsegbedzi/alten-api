package com.alten.challenge.api.service;

import com.alten.challenge.api.dto.CustomerDto;
import com.alten.challenge.api.dto.VehicleDto;
import com.alten.challenge.api.model.Customer;
import com.alten.challenge.api.model.Vehicle;
import com.alten.challenge.api.repo.CustomerRepo;
import com.alten.challenge.api.repo.VehicleRepo;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class MainService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    EntityManager entityManager;

    @Autowired
    VehicleRepo vehicleRepo;

    public List<Customer> getCustomers(Long id) {
        if(id == null){
           return customerRepo.findAll();

        }else{
            return Arrays.asList(customerRepo.findById(id).orElse(null));
        }
    }

    public List<VehicleDto> getVehicles(Long id) {
        if(id == null){
           return entityManager.createNativeQuery("SELECT vehicle.id as id,vehicle.vin as vin,vehicle.reg_num as regNum,vehicle.connected_to as connectedTo,vehicle.status as status, vehicle.create_date_time as createDateTime,vehicle.update_date_time as updateDateTime,customer.name as customerName ,customer.id as customerId FROM customer_vehicles" +
                    " JOIN customer ON customer_vehicles.customer_id = customer.id " +
                    "JOIN vehicle ON customer_vehicles.vehicles_id = vehicle.id").unwrap(org.hibernate.query.Query.class).setResultTransformer(Transformers.aliasToBean(VehicleDto.class)).getResultList();
        }else{
            return (
                    entityManager.createNativeQuery("SELECT vehicle.id as id,vehicle.vin as vin,vehicle.reg_num as regNum,vehicle.connected_to as connectedTo,vehicle.status as status, vehicle.create_date_time as createDateTime,vehicle.update_date_time as updateDateTime,customer.name as customerName ,customer.id as customerId FROM customer_vehicles" +
                            " JOIN customer ON customer_vehicles.customer_id = customer.id " +
                            "JOIN vehicle ON customer_vehicles.vehicles_id = vehicle.id where vehicle.id = ?1").setParameter(1,id).unwrap(org.hibernate.query.Query.class).setResultTransformer(Transformers.aliasToBean(VehicleDto.class)).getResultList());
        }
    }
}
