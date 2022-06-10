package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.models.Station;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StationRepository extends JpaRepository<Station,Long> {
}
