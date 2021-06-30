package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Transports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transportsid;
    private String name;
    private int speed;
    private int capacity;
    private String plate;
    private int routeid;

    public Transports(int transportsid, String name, int speed, int capacity, String plate, int routeid) {
        this.transportsid = transportsid;
        this.name = name;
        this.speed = speed;
        this.capacity = capacity;
        this.plate = plate;
        this.routeid = routeid;
    }
}
