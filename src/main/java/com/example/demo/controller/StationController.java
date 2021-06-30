package com.example.demo.controller;

import com.example.demo.model.Stations;
import com.example.demo.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("/identification")
    public Optional<Stations> getOneStation(@RequestParam int id) {
        return stationService.getOneRecord(id);
    }

    @GetMapping("/all")
    public List<Stations> getAllStations() {
        return stationService.getStationsAll();
    }

    @DeleteMapping("/deleteOne")
    public String deleteOneVehicle(@RequestParam int id) {
        return stationService.deleteOneStation(id);
    }

    @PutMapping("/update")
    public Optional<Stations> updateRecord(@RequestParam int id, @RequestBody Stations stations) {
        return stationService.updateStationName(id, stations);
    }


}
