package uz.pdp.apprailwayapi.country.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.country.service.CountryService;
import uz.pdp.model.country.CountryCreateDto;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.user.UserReceiveDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping("/add")
    public ResponseEntity<?> addCountry(
            @Valid @RequestBody CountryCreateDto countryCreateDto
            ) {
        return ResponseEntity.ok(countryService.addCountry(countryCreateDto));
    }


    @GetMapping("/list")
    public ResponseEntity<?> getAllCountries() {
        ApiResponse apiResponse = countryService.getAllCountries();
        return ResponseEntity.ok(apiResponse.getData());

    }
}
