package com.example.servingwebcontent.repositories;

import java.util.List;

import com.example.servingwebcontent.models.Train;
import com.example.servingwebcontent.models.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {
    List<TrainStation> findByOrderByArrivalTimeAsc();
}
