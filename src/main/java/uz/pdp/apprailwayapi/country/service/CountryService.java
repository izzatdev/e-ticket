package uz.pdp.apprailwayapi.country.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.country.repository.CountryRepository;
import uz.pdp.apprailwayapi.exception.UserCustomException;
import uz.pdp.apprailwayapi.utils.ResponseUtils;
import uz.pdp.model.country.CountryCreateDto;
import uz.pdp.model.response.ApiResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService extends ResponseUtils {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    public ApiResponse addCountry(
            CountryCreateDto countryCreateDto
    ){
        checkCountry(countryCreateDto.getName());
        CountryEntity countryEntity = modelMapper.map(countryCreateDto, CountryEntity.class);
        countryRepository.save(countryEntity);
        return SUCCESS;
    }

    private void checkCountry(String countryName){
        Optional<CountryEntity> optionalCountryEntity = countryRepository.findByName(countryName);

        if (optionalCountryEntity.isPresent())
            throw new UserCustomException(countryName + "  is exist");
    }


    public ApiResponse getAllCountries() {
        return new ApiResponse(1,"success",countryRepository.findAll());
    }
}

