package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Stations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationid;
    private String name;
    private boolean isactive;

    public Stations(int stationid, String name, boolean isactive) {
        this.stationid = stationid;
        this.name = name;
        this.isactive = isactive;
    }
}
