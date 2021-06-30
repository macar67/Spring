package com.example.demo.service;

import com.example.demo.model.Log;
import com.example.demo.model.Transports;
import com.example.demo.repository.LogRepository;
import com.example.demo.repository.RouteStationMapRepository;
import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportsService {
    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private LogService logService;

    @Autowired
    private RouteStationMapRepository routeStationMapRepository;

    @Autowired
    private RouteRepository routeRepository;


    Log log = new Log();

    public Optional<Transports> getOneRecord(int id){
        log.setInfo(id+" ye sahip Araç listelendi.");
        logRepository.save(log);
        return vehiclesRepository.findById(id);
    }
    public List<Transports> getTransportsAll(){
         log.setInfo("Tüm araçlar listelendi");
         logRepository.save(log);
          return vehiclesRepository.findAll();
    }
    public String deleteOneRecord(int id){
         vehiclesRepository.deleteById(id);

         log.setInfo(id+" ' li Araç veritabanımızdan silindi");
         logRepository.save(log);
         return "Silme işlemi başarılı";
    }
    public Optional<Transports> updateTransportSpeed(int transportId,Transports transports){
        return vehiclesRepository.findById(transportId).map(target -> {
            target.setSpeed(transports.getSpeed());
            // update other props... if you want we can add like above ..
            vehiclesRepository.save(target);

            log.setInfo(target.getName() +" Hız degeri "+transports.getSpeed()+" olarak güncellendi.");
            logRepository.save(log);

            return target;
        });
    }

    public ResponseEntity<String> addOneVehicle(Transports vehicle){
        if(vehicle.getPlate() == null){
            return new ResponseEntity<>(
                    "Plaka olmadan yeni bir araç ekleyemezsiniz",
                    HttpStatus.BAD_REQUEST);
        }else{
            vehiclesRepository.save(vehicle);

            log.setInfo(vehicle.getName() +" isimli yeni bir araç eklendi. ");
            logService.saveLog(log);

            return new ResponseEntity<>(
                    "Ekleme işlemi başarılı",
                    HttpStatus.OK);
        }

    }

    public ResponseEntity<String> updateRoute(int transportId,Transports transports){

      if(routeRepository.findById(transports.getRouteid()).toString() ==  "Optional.empty"){

          return new ResponseEntity<>(
                  "Eklemek istediğiniz rota mevcut değil.",
                  HttpStatus.NOT_ACCEPTABLE);

      }
      else{
          vehiclesRepository.findById(transportId).map(target -> {

              target.setRouteid(transports.getRouteid());
              vehiclesRepository.save(target);

              log.setInfo(target.getName() +" aracının rotası güncellendi.");
              logRepository.save(log);


              return new ResponseEntity<>(
                      "İşlem Başarılı",
                      HttpStatus.OK);

          });
      }
        return new ResponseEntity<>(
                "İşlem Başarılı",
                HttpStatus.OK);
    }

}
