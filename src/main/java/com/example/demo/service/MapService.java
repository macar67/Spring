package com.example.demo.service;

import com.example.demo.repository.RouteStationMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    @Autowired
    private RouteStationMapRepository routeStationMapRepository;


}
