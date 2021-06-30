package com.example.demo.service;

import com.example.demo.model.Log;
import com.example.demo.model.Stations;
import com.example.demo.repository.LogRepository;
import com.example.demo.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private LogRepository logRepository;
    Log log = new Log();

    public Optional<Stations> getOneRecord(int id){
        log.setInfo(id+" ye sahip istasyon listelendi.");
        logRepository.save(log);
        return stationRepository.findById(id);
    }
    public List<Stations> getStationsAll(){
        log.setInfo("Tüm istasyonlar listelendi");
        logRepository.save(log);

        return stationRepository.findAll();
    }
    public String deleteOneStation(int id){
        stationRepository.deleteById(id);
        log.setInfo(id+" ye sahip istasyon silindi.");
        logRepository.save(log);
        return "Silme işlemi başarılı";
    }
    public Optional<Stations> updateStationName(int stationId, Stations stations){
        return stationRepository.findById(stationId).map(target -> {
            target.setName(stations.getName());
            stationRepository.save(target);

            log.setInfo(target.getName() +" istasyon isminin degeri "+stations.getName()+" olarak güncellendi.");
            logRepository.save(log);

            return target;
        });
    }


}
