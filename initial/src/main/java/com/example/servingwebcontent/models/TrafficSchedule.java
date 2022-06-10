package com.example.servingwebcontent.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TrafficSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Date day;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "trafficSchedule")
    private Set<TrainStation> trainStations = new HashSet<>(0);

    public TrafficSchedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return day;
    }

    public void setDate(Date day) {
        this.day = day;
    }

    public Set<TrainStation> getTrainStations() {
        return trainStations;
    }

    public void setTrainStations(Set<TrainStation> trainStations) {
        this.trainStations = trainStations;
    }
}
