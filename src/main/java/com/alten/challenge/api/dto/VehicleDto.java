package com.alten.challenge.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class VehicleDto {

    Long id;

    String vin;

    String regNum;

    Long connectedTo;

    String status;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    String customerName;

    Long customerId;

    public void setCustomerId(Number customerId){
        this.customerId = customerId.longValue();
    }

    public void setId(Number id) {
        this.id = id.longValue();
    }


    public void setcreateDateTime(Timestamp date) {
        this.createDateTime = date.toLocalDateTime();
    }
    public void setupdateDateTime(Timestamp date) {
        this.updateDateTime = date.toLocalDateTime();
    }

    public VehicleDto(Long id, String vin, String regNum, Long connectedTo,String status, LocalDateTime createDateTime, LocalDateTime updateDateTime, String customerName, Long customerId) {
        this.id = id;
        this.vin = vin;
        this.regNum = regNum;
        this.connectedTo = connectedTo;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.customerName = customerName;
        this.customerId = customerId;
    }

    //    VehicleDto(Vehicle vehicle, String customerName){
//        this.customerName = customerName;
//        this.id = vehicle.getId();
//        this.vin = vehicle.getVin();
//        this.regNum = vehicle.getRegNum();
//        this.connectedTo = vehicle.getConnectedTo();
//        this.createDateTime = vehicle.getCreateDateTime();
//        this.updateDateTime = vehicle.getUpdateDateTime();
//
//    }




}
