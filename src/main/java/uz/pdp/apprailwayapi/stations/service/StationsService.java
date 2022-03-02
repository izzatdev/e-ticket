package uz.pdp.apprailwayapi.stations.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.apprailwayapi.exception.UserCustomException;
import uz.pdp.apprailwayapi.stations.entity.StationsEntity;
import uz.pdp.apprailwayapi.stations.repository.StationsRepository;
import uz.pdp.apprailwayapi.user.entity.UserEntity;
import uz.pdp.apprailwayapi.utils.ResponseUtils;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.station.StationReceiveDTO;
import uz.pdp.model.user.UserLoginDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StationsService extends ResponseUtils {

    private final StationsRepository stationsRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    // GET ALL STATIONS
    public ApiResponse getStationList(){
        List<StationReceiveDTO> stationReceiveDTOS = new ArrayList<>();

        List<StationsEntity> all = stationsRepository.findAll();
        all.forEach(stationsEntity ->{
            modelMapper.map(stationsEntity, stationsEntity);
        });
        return new ApiResponse(1,"success",stationsRepository.findAll());
    }

    // GET ONE STATION
    public ApiResponse getStationByName( String name ){

        Optional<StationsEntity> optionalStationsEntity = stationsRepository.findByName(name);
        StationReceiveDTO dto = modelMapper.map(optionalStationsEntity.get(), StationReceiveDTO.class);
//        dto.setName(null);
//        dto.set
        return new ApiResponse(1,"success",dto);

    }

    // ADD STATION
    public ApiResponse addStation(StationReceiveDTO stationReceiveDTO ){
        checkStationByName(stationReceiveDTO.getName());
        StationsEntity stationsEntity
                = modelMapper.map(stationReceiveDTO, StationsEntity.class);

        stationsRepository.save(stationsEntity);
        return SUCCESS;

    }

    private void checkStationByName(String name){
        Optional<StationsEntity> optionalStationsEntity
                = stationsRepository.findByName(name);

        if (optionalStationsEntity.isPresent())
            throw new UserCustomException(name + " user is exist");
    }



}
