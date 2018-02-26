package com.research.ml.controller;

import com.research.ml.dto.TrainingDto;
import com.research.ml.dto.VendorDto;
import com.research.ml.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TrainingDto> findAllTrainings() {
        return trainingService.findAllTrainings();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TrainingDto createTraining(@RequestBody TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }
}
