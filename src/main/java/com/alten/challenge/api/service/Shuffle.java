package com.alten.challenge.api.service;

import com.alten.challenge.api.repo.CustomerRepo;
import com.alten.challenge.api.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class Shuffle {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    @Scheduled(fixedRate = 60000)
    public void shuffleVehicleConnectionStatus(){
//        vehicleRepo.updateAll(); // Set all vehicles inter connections to null to prevent unique key violations
//        customerRepo.findAll().stream().forEach(c -> {
//            // Get all ids as list using java 8 streams
//            List<Long> ids = c.getVehicles().stream().mapToLong(e->e.getId()).boxed().collect(Collectors.toList());
//            // add null value to simulate instances of unconnected vehicles
//            ids.add(null);
//            //shuffle to introduce randomness when reassigning connections
//            Collections.shuffle(ids);
//            //for loop to assign vehicles to their new connections
//            for (int i=0;i<c.getVehicles().size();i++){
//                c.getVehicles().get(i).setConnectedTo(ids.get(i));
//                customerRepo.save(c);
//            }
//        });

        List<String> status = Arrays.asList("offline","connected");
        vehicleRepo.findAll().stream().forEach(e ->{
            Collections.shuffle(status);
            e.setStatus(status.get(0));
            vehicleRepo.save(e);
        });
    }

}
