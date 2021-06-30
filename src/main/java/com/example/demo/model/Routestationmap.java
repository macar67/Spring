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
public class Routestationmap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int station;
    private int route;

    public Routestationmap(int id, int station, int route) {
        this.id = id;
        this.station = station;
        this.route = route;
    }


}
