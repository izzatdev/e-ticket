package uz.pdp.apprailwayapi.stations.controller;

import lombok.RequiredArgsConstructor;
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
    @GetMapping("/{name}")
    public ResponseEntity<?> checkUserByPhoneNumber(
            @PathVariable("name") String name
    ) {
        ApiResponse apiResponse = stationsService.getStationByName(name);
        return ResponseEntity.ok(apiResponse.getData());
    }

    // ADD STATION
    @PostMapping("/add")
    public ResponseEntity<?> addUsers(
            @Valid @RequestBody StationReceiveDTO stationReceiveDTO
    ) {
        return ResponseEntity.ok(stationsService.addStation(stationReceiveDTO));
    }




}
