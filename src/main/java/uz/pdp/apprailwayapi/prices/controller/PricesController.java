package uz.pdp.apprailwayapi.prices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.prices.entity.PricesEntity;
import uz.pdp.apprailwayapi.prices.service.PricesService;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PricesController {
    private final PricesService pricesService;

    @GetMapping
    public ResponseEntity<?> getAllPrices() {
        List<PricesEntity> allPrices = pricesService.getAllPrices();
        return ResponseEntity.ok(allPrices);

    }
}
