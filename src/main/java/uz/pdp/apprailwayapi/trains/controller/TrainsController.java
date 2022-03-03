package uz.pdp.apprailwayapi.trains.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apprailwayapi.trains.service.TrainService;

import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.train.TrainCreatedto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/train")
@RequiredArgsConstructor
public class TrainsController {
    private final TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<?> addTrain(
            @Valid @RequestBody TrainCreatedto trainCreatedto
    ) {
        return ResponseEntity.ok(trainService.addTrain(trainCreatedto));
    }


    @GetMapping("/list")
    public ResponseEntity<?> getAllTrains() {
        ApiResponse apiResponse = trainService.getAllTrains();
        return ResponseEntity.ok(apiResponse.getData());

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTrainById(
            @PathVariable Long id
    ) {
        ApiResponse apiResponse = trainService.getTrainById(id);
        return ResponseEntity.ok(apiResponse.getData());

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateTrain(
            @Valid @RequestBody TrainCreatedto trainUpdateDto,
            @PathVariable Long id
    ) {
        ApiResponse apiResponse = trainService.updateTrain(trainUpdateDto, id);
        return ResponseEntity.ok(apiResponse.getMessage());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteTrain(
            @PathVariable Long id
    ) {
        ApiResponse apiResponse = trainService.removeTrain(id);
        return ResponseEntity.ok(apiResponse.getMessage());

    }
}
