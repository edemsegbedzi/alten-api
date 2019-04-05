package com.alten.challenge.api.model;

import com.alten.challenge.api.dto.VehicleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
//@SqlResultSetMapping(
//        name="VehicleDtoMapping",
//        classes={
//                @ConstructorResult(
//                        targetClass=VehicleDto.class,
//                        columns={
//                                @ColumnResult(name="id"),
//                                @ColumnResult(name="vin"),
//                                @ColumnResult(name="regNum"),
//                                @ColumnResult(name="connectedTo"),
//                                @ColumnResult(name="createDateTime"),
//                                @ColumnResult(name="updateDateTime"),
//                                @ColumnResult(name="name")
//                        }
//                )
//        }
//)

//vehicle.id as id,vehicle.vin as vin,vehicle.reg_num as regNum,vehicle.connected_to as connectedTo,vehicle.create_date_time as createDateTime,vehicle.update_date_time as updateDateTime,
//@NamedNativeQuery(name = "findAllWithCustomer",query = "SELECT vehicle.id as id,vehicle.vin as vin,vehicle.reg_num as regNum,vehicle.connected_to as connectedTo,vehicle.create_date_time as createDateTime,vehicle.update_date_time as updateDateTime,\n customer.name as name FROM customer_vehicles " +
//        "JOIN customer ON customer_vehicles.customer_id = customer.id " +
//        "JOIN vehicle ON customer_vehicles.vehicles_id = vehicle.id",resultSetMapping = "VehicleDto")
public class Vehicle {
    public  Vehicle(String vin, String regNum ){
        this.vin = vin;
        this.regNum = regNum;
    }
//
//    public Vehicle(@NotNull String vin, @NotNull String regNum, @NotNull Customer customer) {
//        this.vin = vin;
//        this.regNum = regNum;
//       this.customer = customer;
//    }
//    @ManyToOne
//    @NotNull
//    Customer customer;

    public  Vehicle(String vin, String regNum, Long connectedTo){
        this.vin = vin;
        this.regNum = regNum;
        this.connectedTo = connectedTo;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @NotNull
    @Column(unique = true)
    String vin;
    @NotNull
    @Column(unique = true)
    String regNum;


    @Column(unique = true)
    Long connectedTo;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDateTime;


}
