package com.example.demo.service;

import com.example.demo.model.Log;
import com.example.demo.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void saveLog(Log log){
        logRepository.save(log);
    }
    public List<String> listAllLogs(){

        List<Log> allLogs = logRepository.findAll();

        List<String> info =new ArrayList<>() ;

        for(Log i:allLogs){
            info.add( i.getInfo());
        }
        return info;
    }

}
