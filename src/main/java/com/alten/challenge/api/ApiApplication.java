package com.alten.challenge.api;

import com.alten.challenge.api.dto.VehicleDto;
import com.alten.challenge.api.model.Customer;
import com.alten.challenge.api.model.Vehicle;
import com.alten.challenge.api.repo.CustomerRepo;
import com.alten.challenge.api.repo.VehicleRepo;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class ApiApplication {

    @Autowired
    EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }


    @Bean
    public CommandLineRunner start(CustomerRepo customerRepo, VehicleRepo vehicleRepo){
        return args -> {


                 List<Vehicle> vehicles = Arrays.asList(
                    new Vehicle("YS2R4X20005399401","ABC123","connected"),
                    new Vehicle("VLUR4X20009093588","DEF456","connected"),
                    new Vehicle("VLUR4X20009048066","GHI789","connected"));
            customerRepo.save(new Customer("Kalles Grustransporter AB","Cementvägen 8, 111 11 Södertälje",vehicles));
            vehicles = Arrays.asList(
                            new Vehicle("YS2R4X20005388011","JKL012","connected"),
                            new Vehicle("YS2R4X20005387949","MNO345","connected"));
            customerRepo.save(new Customer("Johans Bulk AB","Balkvägen 12, 222 22 Stockholm", vehicles));

                   vehicles = Arrays.asList(
                            new Vehicle("YS2R4X20005387765","PQR678","offline"),
                            new Vehicle("YS2R4X20005387055","STU901","connected"));
                   customerRepo.save(new Customer("Haralds Värdetransporter AB","Budgetvägen 1, 333 33 Uppsala", vehicles));


//             List<VehicleDto> dtos =entityManager.createNativeQuery("SELECT vehicle.id as id,vehicle.vin as vin,vehicle.reg_num as regNum,vehicle.connected_to as connectedTo,vehicle.status as status, vehicle.create_date_time as createDateTime,vehicle.update_date_time as updateDateTime,customer.name as customerName,customer.id as customerId FROM customer_vehicles" +
//                   " JOIN customer ON customer_vehicles.customer_id = customer.id " +
//                    "JOIN vehicle ON customer_vehicles.vehicles_id = vehicle.id").unwrap(org.hibernate.query.Query.class).setResultTransformer(Transformers.aliasToBean(VehicleDto.class)).getResultList();

        };

    }
}
