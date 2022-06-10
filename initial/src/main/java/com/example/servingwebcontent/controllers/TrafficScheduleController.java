package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.*;
import com.example.servingwebcontent.repositories.*;
import com.example.servingwebcontent.service.TrainStationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Set;

@Controller
public class TrafficScheduleController {
    final
    StationRepository stationRepository;
    final
    TrafficScheduleRepository trafficScheduleRepository;
    
    final TrainRepository trainRepository;
    final TrainStationRepository trainStationRepository;
     
    final TrainStationService trainStationService;

    public TrafficScheduleController(TrainStationService trainStationService, StationRepository stationRepository, TrafficScheduleRepository trafficScheduleRepository, TrainRepository trainRepository, TrainStationRepository trainStationRepository) {
        this.stationRepository = stationRepository;
        this.trafficScheduleRepository = trafficScheduleRepository;
        this.trainRepository = trainRepository;
        this.trainStationRepository = trainStationRepository;
        this.trainStationService = trainStationService;
    }

    @GetMapping("/")
    public String getAllTables(Model model) {
        Iterable<Station> stations = stationRepository.findAll();
        Iterable<TrafficSchedule> traffic = trafficScheduleRepository.findAll();
        Iterable<Train> trains = trainRepository.findAll();
        model.addAttribute("stations", stations);
        model.addAttribute("traffic", traffic);
        model.addAttribute("trains", trains);
        return "index";
    }

    @GetMapping("/traffic_schedule/add")
    public String addTrafficSchedule() {
        return "addTrafficSchedule";
    }

    @PostMapping("/traffic_schedule/add")
    public String storeTrafficSchedule(@RequestParam Date date) {
        TrafficSchedule traffic = new TrafficSchedule();
        traffic.setDate(date);
        trafficScheduleRepository.save(traffic);
        return "redirect:/";
    }

    @GetMapping("/traffic_schedule/{id}/add")
    public String addTrafficPoint(Model model, @PathVariable(value = "id") long id) {
        Iterable<Station> stations = stationRepository.findAll();
        Iterable<Train> trains = trainRepository.findAll();
        TrafficSchedule trafficSchedule = trafficScheduleRepository.findById(id).orElseThrow();
        model.addAttribute("stations", stations);
        model.addAttribute("trains", trains);
        model.addAttribute("trafficSchedule", trafficSchedule);
        return "addTrafficPoint";
    }

    @PostMapping("/traffic_schedule/{id}/add")
    public String storeTrafficPoint(
            @RequestParam Long station_id,
            @RequestParam Long train_id,
            @RequestParam String arrival_time,
            @RequestParam String departure_time,
            @RequestParam String direction,
            @RequestParam(defaultValue = "false") String is_here_train,
            @PathVariable(value = "id") long id) {
        TrafficSchedule traffic = trafficScheduleRepository.findById(id).orElseThrow();

        TrainStation trainStation = new TrainStation();
        trainStation.setHereTrain(Boolean.parseBoolean(is_here_train));
        trainStation.setStation(stationRepository.findById(station_id).orElseThrow());
        trainStation.setTrain(trainRepository.findById(train_id).orElseThrow());
        trainStation.setTrafficSchedule(traffic);
        trainStation.setArrivalTime(Time.valueOf(arrival_time));
        trainStation.setDelay(Time.valueOf("00:00:00"));
        trainStation.setDepartureTime(Time.valueOf(departure_time));
        trainStation.setDirection(direction);
        trainStationRepository.save(trainStation);

        return "redirect:/";
    }

    @PostMapping("/traffic_schedule/{id}/remove")
    public String deleteTraffic(@PathVariable(value = "id") long id) {
        trainStationRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/traffic_schedule/{id}/generate_random_delay")
    public String generateRandomDelay(@PathVariable(value = "id") long id) {
        trainStationService.generateRandomDelay(id);
        return "redirect:/";
    }
}
