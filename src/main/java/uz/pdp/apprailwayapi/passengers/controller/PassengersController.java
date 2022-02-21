package uz.pdp.apprailwayapi.passengers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.passengers.entity.PassengersEntity;
import uz.pdp.apprailwayapi.passengers.service.PassengersService;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengersController {
    private final PassengersService passengersService;

    @GetMapping
    public ResponseEntity<?> getAllPassengers() {
        List<PassengersEntity> allPassengers = passengersService.getAllPassengers();
        return ResponseEntity.ok(allPassengers);

    }
}
