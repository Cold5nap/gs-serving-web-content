package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Train;
import com.example.servingwebcontent.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    @PostMapping("/trains/add")
    public String storeTrain() {
        trainRepository.save(new Train());
        return "redirect:/";
    }
    @PostMapping("/trains/{id}/remove")
    public String deleteTrain(@PathVariable(value="id") long id) {
        Train train = trainRepository.findById(id).orElseThrow();
        trainRepository.delete(train);
        return "redirect:/";
    }
}
