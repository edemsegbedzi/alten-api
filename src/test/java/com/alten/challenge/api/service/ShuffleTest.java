package com.alten.challenge.api.service;

import com.alten.challenge.api.repo.VehicleRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShuffleTest {

    @Autowired
    Shuffle shuffle;
    @Autowired
    VehicleRepo vehicleRepo;

    @Test
    public void vehiclesShouldBeShuffled() {
        LocalDateTime localDateTime = vehicleRepo.findFirst().getUpdateDateTime();
        shuffle.shuffleVehicleConnectionStatus();
        assertNotEquals(localDateTime.toString(),vehicleRepo.findFirst().getUpdateDateTime().toString());
    }
}