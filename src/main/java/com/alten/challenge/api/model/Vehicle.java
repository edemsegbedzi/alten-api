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
public class Vehicle {
    public  Vehicle(String vin, String regNum ){
        this.vin = vin;
        this.regNum = regNum;
    }


    public  Vehicle(String vin, String regNum, String  status){
        this.vin = vin;
        this.regNum = regNum;
        this.status = status;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull
    @Column(unique = true)
    String vin;
    @NotNull
    @Column(unique = true)
    String regNum;


    @Column(unique = true)
    Long connectedTo;

    String status;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDateTime;


}
