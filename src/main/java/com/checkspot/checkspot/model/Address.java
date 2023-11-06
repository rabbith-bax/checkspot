package com.checkspot.checkspot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long addressId;
    @Column(nullable = false)
    private String streetName;
    private String houseNumber;
    private int  apartmentNumber;
    private int floor;
    private String neighborhood;
}
