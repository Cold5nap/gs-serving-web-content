package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.models.TrafficSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrafficScheduleRepository extends JpaRepository<TrafficSchedule,Long> {
}
