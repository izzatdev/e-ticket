package uz.pdp.apprailwayapi.country.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.country.repository.CountryRepository;
import uz.pdp.model.response.ApiResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public ApiResponse getAllCountries() {
        return new ApiResponse(1,"success",countryRepository.findAll());
    }
}

