package uz.pdp.apprailwayapi.district.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprailwayapi.district.entity.DistrictEntity;
import uz.pdp.apprailwayapi.district.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping
    public ResponseEntity<?> getAllDistricts() {
        List<DistrictEntity> allDistricts = districtService.getAlDistricts();
        return ResponseEntity.ok(allDistricts);

    }
}
