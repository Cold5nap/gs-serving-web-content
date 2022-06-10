package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Station;
import com.example.servingwebcontent.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StationController {
    @Autowired
    StationRepository stationRepository;

    @GetMapping("/stations/add")
    public String addStation() {
        return "addStation";
    }

    @PostMapping("/stations/add")
    public String storeStation(@RequestParam String name,
                               @RequestParam(required = false,defaultValue ="isNotDepot") String isDepot) {
        Station station = new Station();
        station.setName(name);
        if (isDepot.equals("isDepot")){
            station.setIs_depot(true);
        }else{
            station.setIs_depot(false);
        }
        stationRepository.save(station);
        return "redirect:/";
    }
    @PostMapping("/stations/{id}/remove")
    public String deleteStation(@PathVariable(value="id") long id) {
        Station station = stationRepository.findById(id).orElseThrow();
        stationRepository.delete(station);
        return "redirect:/";
    }
}
