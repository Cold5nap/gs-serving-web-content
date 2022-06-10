package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends JpaRepository<Train,Long> {
}
