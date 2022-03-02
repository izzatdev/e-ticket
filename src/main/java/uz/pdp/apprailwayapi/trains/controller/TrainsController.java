package uz.pdp.apprailwayapi.trains.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;
import uz.pdp.apprailwayapi.trains.service.TrainService;

import uz.pdp.model.country.CountryCreateDto;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.train.TrainCreatedto;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<?> getAllTrains(){
        ApiResponse apiResponse = trainService.getAllTrains();
        return ResponseEntity.ok(apiResponse.getData());

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTrainById(
            @PathVariable Long id
    ){
        ApiResponse apiResponse = trainService.getTrainById(id);
        return ResponseEntity.ok(apiResponse.getData());

    }
//    @PostMapping("add")
//    public ResponseEntity<?> addTrain(@RequestBody TrainCreatedto trainCreatedto) {
//        ApiResponse apiResponse = trainService.add(trainCreatedto);
//        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse.getMessage());
//    }
//
//    @PutMapping("edit")
//    public ResponseEntity<?> editTrain(@RequestParam Long id, @RequestBody TrainCreatedto trainCreatedto) {
//        ApiResponse apiResponse = trainService.edit(id, trainCreatedto);
//        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse.getMessage());
//    }
//
//    @GetMapping()
//    public ResponseEntity<?> getAllTrains() {
//        List<TrainsEntity> trainsEntities = trainService.get();
//        return ResponseEntity.ok(trainsEntities);
//    }
//
//    @GetMapping()
//    public ResponseEntity<?> getById() {
//        List<TrainsEntity> trainsEntities = trainService.get();
//        return ResponseEntity.ok(trainsEntities);
//    }
}