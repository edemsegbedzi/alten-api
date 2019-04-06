package com.alten.challenge.api.repo;

import com.alten.challenge.api.dto.VehicleDto;
import com.alten.challenge.api.model.Customer;
import com.alten.challenge.api.model.Vehicle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EntityManager;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

public interface VehicleRepo  extends CrudRepository<Vehicle,Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE vehicle SET connected_to = NULL ",nativeQuery = true)
    void updateAll();

    @Query(value = "SELECT * FROM vehicle LIMIT 1 ",nativeQuery = true)
    Vehicle findFirst();

    List<Vehicle> findAll();



}
