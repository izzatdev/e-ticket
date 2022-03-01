package uz.pdp.apprailwayapi.district.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apprailwayapi.district.entity.DistrictEntity;
import uz.pdp.apprailwayapi.district.service.DistrictService;
import uz.pdp.model.country.CountryCreateDto;
import uz.pdp.model.district.DistrictReceiveDTO;
import uz.pdp.model.response.ApiResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @PostMapping("/add")
    public ResponseEntity<?> addDistrict(
            @Valid @RequestBody DistrictReceiveDTO districtReceiveDTO
            ) {
        return ResponseEntity.ok(districtService.addDistrict(districtReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllDistricts() {
        ApiResponse apiResponse = districtService.getAllDistricts();
        return ResponseEntity.ok(apiResponse.getData());

    }
}
