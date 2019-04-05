package com.alten.challenge.api.dto;

import com.alten.challenge.api.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    Long id;

    String vin;

    String regNum;

    Long connectedTo;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    String name;

    public void setId(Number id) {
        this.id = id.longValue();
    }

    public void setcreateDateTime(Timestamp date) {
        this.createDateTime = date.toLocalDateTime();
    }
    public void setupdateDateTime(Timestamp date) {
        this.updateDateTime = date.toLocalDateTime();
    }

    public VehicleDto(Long id, String vin, String regNum, Long connectedTo, LocalDateTime createDateTime, LocalDateTime updateDateTime, String name) {
        this.id = id;
        this.vin = vin;
        this.regNum = regNum;
        this.connectedTo = connectedTo;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.name = name;
    }

    //    VehicleDto(Vehicle vehicle, String name){
//        this.name = name;
//        this.id = vehicle.getId();
//        this.vin = vehicle.getVin();
//        this.regNum = vehicle.getRegNum();
//        this.connectedTo = vehicle.getConnectedTo();
//        this.createDateTime = vehicle.getCreateDateTime();
//        this.updateDateTime = vehicle.getUpdateDateTime();
//
//    }




}
