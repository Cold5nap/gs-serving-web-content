package com.example.servingwebcontent.service;

import java.sql.Time;
import java.util.Set;

import com.example.servingwebcontent.models.TrafficSchedule;
import com.example.servingwebcontent.models.TrainStation;
import com.example.servingwebcontent.repositories.TrafficScheduleRepository;
import com.example.servingwebcontent.repositories.TrainStationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainStationService {
    
    final TrafficScheduleRepository trafficScheduleRepository;

    @Autowired
    public TrainStationService(TrafficScheduleRepository trafficScheduleRepository) {
        this.trafficScheduleRepository = trafficScheduleRepository;
    }

    public void generateRandomDelay(long id) {
        TrafficSchedule trafficSchedule = trafficScheduleRepository.findById(id).orElseThrow();
        Set<TrainStation> trainStationSet = trafficSchedule.getTrainStations();
        int delay = (int) (Math.random() * 60);
        for (TrainStation ts : trainStationSet) {
            long seconds = delay + ts.getDelay().getTime() / 1000;
            ts.setDelay(Time
                    .valueOf(String.format("%02d:%02d:%02d", seconds / 3600 + 3, seconds / 60 % 60, seconds / 1 % 60)));

            seconds = delay + ts.getArrivalTime().getTime() / 1000;
            ts.setArrivalTime(
                    Time.valueOf(
                            String.format("%02d:%02d:%02d", seconds / 3600 + 3, seconds / 60 % 60, seconds / 1 % 60)));

            seconds = delay + ts.getDepartureTime().getTime() / 1000;
            ts.setDepartureTime(
                    Time.valueOf(
                            String.format("%02d:%02d:%02d", seconds / 3600 + 3, seconds / 60 % 60, seconds / 1 % 60)));
        }
        trafficScheduleRepository.save(trafficSchedule);
    }
}
