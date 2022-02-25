package uz.pdp.apprailwayapi.seats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprailwayapi.seats.entity.SeatsEntity;
import uz.pdp.apprailwayapi.seats.service.SeatsService;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatsController {
    private final SeatsService seatsService;

    @GetMapping
    public ResponseEntity<?> getAllSeats() {
        List<SeatsEntity> allSeats = seatsService.getAllSeats();
        return ResponseEntity.ok(allSeats);

    }
}
