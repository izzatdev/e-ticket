package uz.pdp.apprailwayapi.district.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.country.repository.CountryRepository;
import uz.pdp.apprailwayapi.district.entity.DistrictEntity;
import uz.pdp.apprailwayapi.district.repository.DistrictRepository;
import uz.pdp.apprailwayapi.exception.UserCustomException;
import uz.pdp.apprailwayapi.utils.ResponseUtils;
import uz.pdp.model.country.CountryCreateDto;
import uz.pdp.model.district.DistrictReceiveDTO;
import uz.pdp.model.response.ApiResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictService extends ResponseUtils {
    private final DistrictRepository districtRepository;
    private final ModelMapper modelMapper;

    public ApiResponse addDistrict(
            DistrictReceiveDTO districtReceiveDTO
    ){
        checkDistrict(districtReceiveDTO.getName());
        DistrictEntity districtEntity = modelMapper.map(districtReceiveDTO, DistrictEntity.class);
        districtRepository.save(districtEntity);
        return SUCCESS;
    }

    private void checkDistrict(String districtName){
        Optional<DistrictEntity> optionalDistrictEntity = districtRepository.findByName(districtName);

        if (optionalDistrictEntity.isPresent())
            throw new UserCustomException(districtName + "  is exist");
    }


    public ApiResponse getAllDistricts() {
        return new ApiResponse(1,"success",districtRepository.findAll());
    }
}

