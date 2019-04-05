package com.alten.challenge.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    public Customer(@NotNull String name, @NotNull String address, @NotNull List<Vehicle> vehicles) {
        this.name = name;
        this.address = address;
        this.vehicles = vehicles;
    }
    public Customer(@NotNull String name, @NotNull String address) {
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @NotNull
    String name,address;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    List<Vehicle> vehicles;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

}
