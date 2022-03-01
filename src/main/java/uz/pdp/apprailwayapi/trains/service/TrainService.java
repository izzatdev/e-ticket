package uz.pdp.apprailwayapi.trains.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.base.service.BaseService;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.country.repository.CountryRepository;
import uz.pdp.apprailwayapi.exception.UserCustomException;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;
import uz.pdp.apprailwayapi.trains.repository.TrainRepository;
import uz.pdp.apprailwayapi.utils.ResponseUtils;
import uz.pdp.apprailwayapi.wagons.entity.WagonEntity;
import uz.pdp.apprailwayapi.wagons.repository.WagonRepository;
import uz.pdp.model.country.CountryCreateDto;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.train.TrainCreatedto;
import uz.pdp.model.wagon.WagonCreateDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainService extends ResponseUtils {

    private final TrainRepository trainRepository;
    private final WagonRepository wagonRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public ApiResponse add(TrainCreatedto trainReceiveDTO) {
//        TrainsEntity train = modelMapper.map(trainReceiveDTO, TrainsEntity.class);
//        if (trainRepository.existsByName(train.getName())) {
//            return new ApiResponse(0, "This train already exists");
//        }
//        trainRepository.save(train);
//        return new ApiResponse(1, "success");
//    }

    public ApiResponse addTrain(
            TrainCreatedto trainCreatedto
    ){
        checkTrain(trainCreatedto.getName());

//        List<WagonCreateDTO> wagonCreateDTO= trainCreatedto.getWagons();
//
//        for (int i=0; i<wagonCreateDTO.size()-2;i++) {
//
//            WagonEntity wagonEntity = modelMapper.map(wagonCreateDTO.get(i),WagonEntity.class);
//            wagonRepository.save(wagonEntity);
//        }

        TrainsEntity trainsEntity = modelMapper.map(trainCreatedto, TrainsEntity.class);
        trainRepository.save(trainsEntity);
        return SUCCESS;
    }
    private void checkTrain(String trainName){
        Optional<TrainsEntity> optionalTrainsEntity = trainRepository.findByName(trainName);

        if (optionalTrainsEntity.isPresent())
            throw new UserCustomException(trainName + "  is exist");
    }


    public ApiResponse getAllTrains() {
        return new ApiResponse(1,"success",trainRepository.findAll());
    }



//    @Override
//    public TrainsEntity getById(Long id) {
//        Optional<TrainsEntity> optional = trainRepository.findById(id);
//        return optional.get();
//    }
//
//    @Override
//    public List<TrainsEntity> get() {
//        return trainRepository.findAll();
//    }
//
//    @Override
//    public ApiResponse delete(TrainCreatedto trainReceiveDTO) {
//        if (trainRepository.existsByName(trainReceiveDTO.getName())) {
//            TrainsEntity map = modelMapper.map(trainReceiveDTO, TrainsEntity.class);
//            trainRepository.delete(map);
//            return new ApiResponse(1, "Train was deleted");
//        }
//        return new ApiResponse(0, "Train not found");
//    }
//
//    @Override
//    public ApiResponse edit(Long id, TrainCreatedto trainReceiveDTO) {
//        Optional<TrainsEntity> optional = trainRepository.findById(id);
//        if (optional.isPresent()) {
//            TrainsEntity train = optional.get();
//            Set<WagonEntity> wagonEntities = trainReceiveDTO.getWagons().stream().map(wagonCreateDTO->modelMapper.map(wagonCreateDTO, WagonEntity.class)).collect(Collectors.toSet());
//            train.setWagons(wagonEntities);
//            trainRepository.save(train);
//            return new ApiResponse(1, "Train updated");
//        }
//        return new ApiResponse(0, "Train not found");
//    }
}