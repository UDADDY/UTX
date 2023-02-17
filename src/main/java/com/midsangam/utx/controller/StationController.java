package com.midsangam.utx.controller;

import com.midsangam.utx.model.Station;
import com.midsangam.utx.services.StationService;
import com.midsangam.utx.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @PostMapping
    public String create(@RequestBody Station station){
        stationService.createStation(station);
        return "new station created!";
    }

    @GetMapping("/{stationId}")
    public Station findById(@PathVariable int stationId){
        Station station = stationService.findStationById(stationId);
        return station;
    }

    @GetMapping("/all")
    public List<Station> findAll(){
        return stationService.findAllStation();
    }

    @PutMapping("/{stationId}")
    public String update(@PathVariable int stationId, @RequestBody Station station) {
        
        return null;
    }

    @DeleteMapping("/{stationId}")
    public String delete(@PathVariable int stationId){
        stationService.deleteStation(stationId);

        return "Deleted!";
    }
}