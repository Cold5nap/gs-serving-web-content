package com.example.servingwebcontent.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private boolean is_depot;

    @Column(nullable = false)
    private String name;


    public Station() {
    }

    public Station(String name, boolean is_depot) {
        this.is_depot = is_depot;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean is_depot() {
        return is_depot;
    }

    public void setIs_depot(boolean is_depot) {
        this.is_depot = is_depot;
    }

}
