package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Routestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Route route;
    private Stations[] stations;

    public Routestation(int id, Route route, Stations[] stations) {
        this.id = id;
        this.route = route;
        this.stations = stations;
    }
}
