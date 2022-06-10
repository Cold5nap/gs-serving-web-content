package com.example.servingwebcontent.models;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class TrainStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="station_id", nullable=false)
    private Station station;

    @ManyToOne
    @JoinColumn(name="train_id", nullable=false)
    private Train train;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="trafficShedule_id", nullable=false)
    private TrafficSchedule trafficSchedule;

    @Column(nullable = false)
    private Time arrivalTime;

    @Column(nullable = false)
    private Time departureTime;

    @Column(nullable = false)
    private Time delay;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private boolean isHereTrain;

    public TrainStation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getDelay() {
        return this.delay;
    }

    public void setDelay(Time delay) {
        this.delay = delay;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TrafficSchedule getTrafficSchedule() {
        return trafficSchedule;
    }

    public void setTrafficSchedule(TrafficSchedule trafficSchedule) {
        this.trafficSchedule = trafficSchedule;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public boolean isHereTrain() {
        return isHereTrain;
    }

    public void setHereTrain(boolean hereTrain) {
        isHereTrain = hereTrain;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
