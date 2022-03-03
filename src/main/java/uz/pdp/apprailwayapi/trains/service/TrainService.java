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
import uz.pdp.model.train.TrainResponseDto;
import uz.pdp.model.wagon.WagonCreateDTO;
import uz.pdp.model.wagon.WagonResponseDto;

import java.util.ArrayList;
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


        TrainsEntity trainsEntity = modelMapper.map(trainCreatedto, TrainsEntity.class);
        TrainsEntity save = trainRepository.save(trainsEntity);

        List<WagonCreateDTO> wagonCreateDTO= trainCreatedto.getWagons();

        for (int i=0; i<wagonCreateDTO.size();i++) {
            WagonEntity wagonEntity = modelMapper.map(wagonCreateDTO.get(i),WagonEntity.class);
            wagonEntity.setTrains(save);
            wagonRepository.save(wagonEntity);
        }
        return SUCCESS;
    }

    private void checkTrain(String trainName){
        Optional<TrainsEntity> optionalTrainsEntity = trainRepository.findByName(trainName);

        if (optionalTrainsEntity.isPresent())
            throw new UserCustomException(trainName + "  is exist");
    }


    public ApiResponse getAllTrains() {
        List<TrainsEntity> trainsEntities = trainRepository.findAll();
        List<TrainResponseDto> trainResponseDtos = new ArrayList<>();

        for (int i = 0; i < trainsEntities.size(); i++) {
            TrainResponseDto trains = new TrainResponseDto();
            trains.setId(trainsEntities.get(i).getId());
            trains.setCount_wagon(trainsEntities.get(i).getCount_wagon());
            trains.setName(trainsEntities.get(i).getName());
            trains.setTotal_seats(trainsEntities.get(i).getFree_seats());
            trains.setSpeed(trainsEntities.get(i).getSpeed());
            trains.setWagons(null);
            trains.setSchedules(null);
            trainResponseDtos.add(trains);
        }
        return new ApiResponse(1,"success",trainResponseDtos);
    }

    public ApiResponse getTrainById(Long trainId){
        Optional<TrainsEntity> train = trainRepository.findById(trainId);
        TrainResponseDto trainResponseDto = new TrainResponseDto();
        if (train.isPresent()) {
            trainResponseDto.setId(train.get().getId());
            trainResponseDto.setName(train.get().getName());
            trainResponseDto.setSpeed(train.get().getSpeed());
            trainResponseDto.setCount_wagon(train.get().getCount_wagon());
            trainResponseDto.setTotal_seats(train.get().getFree_seats());

            List<WagonResponseDto> wagons = (List<WagonResponseDto>) (List<?>) train.get().getWagons();

            trainResponseDto.setWagons(wagons);
            trainResponseDto.setSchedules(null);
            return new ApiResponse(1,"success",trainResponseDto);
        }
        else
            return new ApiResponse(0,"train not Found");

    }
    public ApiResponse updateTrain(TrainCreatedto trainUpdate, long id){
        Optional<TrainsEntity> train = trainRepository.findById(id);
        if(train.isPresent()) {
            TrainsEntity trainEntity = train.get();
            modelMapper.map(trainUpdate, trainEntity);
            trainEntity.setId(id);

            return new ApiResponse(1, "updated");
        }
        else return new ApiResponse(0,"train not Found");
    }

    public ApiResponse removeTrain(long id){
        Optional<TrainsEntity> train = trainRepository.findById(id);
        if(train.isPresent()) {
            TrainsEntity trainEntity = train.get();
        trainEntity.setActive(false);
        return new ApiResponse(1, "removed");
        }
        else return new ApiResponse(0,"train not Found");
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