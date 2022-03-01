package uz.pdp.apprailwayapi.country.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.country.service.CountryService;
import uz.pdp.model.response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllCountries() {
        ApiResponse apiResponse = countryService.getAllCountries();
        return ResponseEntity.ok(apiResponse.getData());

    }
}
