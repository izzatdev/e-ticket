package uz.pdp.apprailwayapi.trains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;
import uz.pdp.apprailwayapi.trains.service.TrainService;
import uz.pdp.model.ApiResponse;
import uz.pdp.model.train.TrainCreatedto;

import java.util.List;

@RestController
@RequestMapping("/api/train")
public class Controller {
    @Autowired
    private TrainService trainService;

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