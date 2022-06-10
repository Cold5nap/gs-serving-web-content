package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Station;
import com.example.servingwebcontent.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetroLineController {
    @Autowired
    StationRepository stationRepository;

    @GetMapping("/stations")
    public String stations(Model model) {
        Iterable<Station> stations = stationRepository.findAll();
        model.addAttribute("stations", stations);
        return "stations";
    }

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Station> stations = stationRepository.findAll();
        model.addAttribute("stations", stations);
        return "metroLine";
    }
}
