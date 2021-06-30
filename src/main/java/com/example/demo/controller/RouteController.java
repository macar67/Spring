package com.example.demo.controller;

import com.example.demo.model.Route;
import com.example.demo.model.Routestation;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping("/identification")
    public Optional<Route> getOneRoute(@RequestParam int id) {
        return routeService.getOneRecord(id);
    }

    @GetMapping("/all")
    public List<Route> getAllRoutes() {
        return routeService.getRoutesAll();
    }

    @DeleteMapping("/deleteOne")
    public String deleteOneRoute(@RequestParam int id) {
        return routeService.deleteOneRoute(id);
    }

    @PutMapping("/update")
    public Optional<Route> updateRecord(@RequestParam int id, @RequestBody Route route) {
        return routeService.updateRouteName(id, route);
    }

    @PostMapping("/addNewRoute")
    public ResponseEntity<String> addNewRoute(@RequestBody Routestation obj) {
        return routeService.saveNewRoute(obj);
    }




}
