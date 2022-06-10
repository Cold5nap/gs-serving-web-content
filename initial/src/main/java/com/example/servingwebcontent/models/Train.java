package com.example.servingwebcontent.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany( mappedBy = "train")
    private Set<TrainStation> trainStations = new HashSet<>(0);

    public Train() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
