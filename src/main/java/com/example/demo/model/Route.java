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
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeid;
    private String name;
    private int stationnumber;

    public Route(int routeid, String name, int stationnumber) {
        this.routeid = routeid;
        this.name = name;
        this.stationnumber = stationnumber;
    }
}
