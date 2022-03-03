package uz.pdp.apprailwayapi.stations.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apprailwayapi.stations.service.StationsService;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.station.StationReceiveDTO;
import uz.pdp.model.user.UserLoginDTO;
import uz.pdp.model.user.UserReceiveDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/station")
public class StationsController {

    private final StationsService stationsService;

    // GET ALL STATIONS LIST
    @GetMapping("/list")
    public ResponseEntity<?> getUser() {
        ApiResponse apiResponse = stationsService.getStationList();
        return ResponseEntity.ok(apiResponse.getData());
    }

    // GET ONE STATION BY NAME
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getUserByPhoneNumber(
            @PathVariable("name") String name
    ) {
        ApiResponse apiResponse = stationsService.getStationByName(name);
        return ResponseEntity.ok(apiResponse.getData());
    }


    // GET ONE STATION BY NAME
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable("id") Long id
    ) {
        ApiResponse apiResponse = stationsService.getStationById(id);
        return ResponseEntity.ok(apiResponse.getData());
    }


    // ADD STATION
    @PostMapping("/add")
    public ResponseEntity<?> addUsers(
            @Valid @RequestBody StationReceiveDTO stationReceiveDTO
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(stationsService.addStation(stationReceiveDTO));
//        return ResponseEntity.ok(stationsService.addStation(stationReceiveDTO));
    }

    // EDIT STATION
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editStation(
            @PathVariable Long id,
            @Valid @RequestBody StationReceiveDTO stationReceiveDTO
    ){
        return ResponseEntity.status(HttpStatus.OK).body(stationsService.editStation(id, stationReceiveDTO));
    }


    // DELETE STATION
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> editStation(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(stationsService.deleteStation(id));
    }



}
