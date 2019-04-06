package com.alten.challenge.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainServiceTest {

    @Autowired
    MainService mainService;
    @Test
    public void getCustomersShouldNotBeNull() {
        assertNotNull(mainService.getCustomers(null));
    }
    @Test
    public void getCustomersShouldBeNull() {
        assertNull(mainService.getCustomers(-1L).get(0));
    }
    @Test
    public void getCustomersShouldNotBeEmpty() {
        System.out.println(mainService.getCustomers(-1L));
        assertTrue(mainService.getCustomers(-1L).size() > 0);
    }
    @Test
    public void getVehiclesShouldNotBeNull() {
        assertNotNull(mainService.getVehicles(null));
    }
    @Test
    public void getVehiclesShouldBeEmpty() {

        assertTrue(mainService.getVehicles(-1L).size() == 0);
    }

}