package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.LogRepository;
import com.example.demo.repository.RouteStationMapRepository;
import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteStationMapRepository routeStationMapRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private LogRepository logRepository;
    Log log = new Log();

    public Optional<Route> getOneRecord(int id){
        log.setInfo(id+" ye sahip rotalar listelendi.");
        logRepository.save(log);
        return routeRepository.findById(id);
    }
    public List<Route> getRoutesAll(){
        log.setInfo("Tüm rotalar listelendi");
        logRepository.save(log);
        return routeRepository.findAll();
    }
    public String deleteOneRoute(int id){
        routeRepository.deleteById(id);
        log.setInfo(id+" ye sahip rota silindi.");
        logRepository.save(log);
        return "Silme işlemi başarılı";
    }
    public Optional<Route> updateRouteName(int routeId, Route route){
        return routeRepository.findById(routeId).map(target -> {
            target.setName(route.getName());
            routeRepository.save(target);

            log.setInfo(target.getName() +" rota isminin degeri "+route.getName()+" olarak güncellendi.");
            logRepository.save(log);

            return target;
        });
    }
    public ResponseEntity<String> saveNewRoute(Routestation obj){

        int counterOfStations = obj.getRoute().getStationnumber();
        if( counterOfStations < 2){
            return new ResponseEntity<>(
                    "Bir rota eklemek için en az 2 istasyon gereklidir.",
                    HttpStatus.BAD_REQUEST);
        }

        else if(stationRepository.findById(obj.getStations()[0].getStationid()).toString() == "Optional.empty"
                || stationRepository.findById(obj.getStations()[1].getStationid()).toString() == "Optional.empty" ){

            return new ResponseEntity<>(
                    "Veri Tabanımızda olmayan bir istasyonu rotanıza ekleyemezsiniz!",
                    HttpStatus.BAD_REQUEST);
        }else{

            for (int i=0 ; i<obj.getStations().length ; i++){
                Routestationmap routestationmapObj = new Routestationmap();
                routestationmapObj.setRoute(obj.getRoute().getRouteid());
                int station = obj.getStations()[i].getStationid();
                routestationmapObj.setStation(station);
                routeStationMapRepository.save(routestationmapObj);
            }
            routeRepository.save(obj.getRoute());
        }


        return new ResponseEntity<>(
                "Yeni bir rota eklendi !",
                HttpStatus.OK);
    }

}
