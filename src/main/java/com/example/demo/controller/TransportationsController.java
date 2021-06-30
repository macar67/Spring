package com.example.demo.controller;

import com.example.demo.model.Transports;
import com.example.demo.service.TransportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transport")
public class TransportationsController {

    @Autowired
    private TransportsService transportsService;

    @PostMapping("/identification")
    public Optional<Transports> getOne(@RequestParam int id){
        return transportsService.getOneRecord(id);
    }

    @GetMapping("/all")
    public List<Transports> getAllTransports(){
      return transportsService.getTransportsAll();
    }

    @DeleteMapping("/deleteOne")
    public String deleteOneVehicle(@RequestParam int id){
        return transportsService.deleteOneRecord(id);
    }
    @PutMapping("/update")
    public Optional<Transports> updateRecord(@RequestParam int id, @RequestBody Transports transports){
        return transportsService.updateTransportSpeed(id,transports);
    }

    @PostMapping("/addOneVehicle")
    public ResponseEntity<String> addOneVehicle (@RequestBody Transports vehicle){
       return transportsService.addOneVehicle(vehicle);
    }
    @PutMapping("/updateRoute")
    public ResponseEntity<String> updateRouteOfVehicle(@RequestParam int id, @RequestBody Transports transports){
        return transportsService.updateRoute(id,transports);
    }


}
