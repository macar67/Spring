package com.example.demo.controller;

import com.example.demo.model.Log;
import com.example.demo.model.Route;
import com.example.demo.service.LogService;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/add")
    public void addNewEvent(@RequestBody Log log){
        logService.saveLog(log);
    }

    @GetMapping("/list")
    public List<String> getAllLogs() {
        return logService.listAllLogs();
    }

}
