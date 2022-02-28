package uz.pdp.apprailwayapi.trains.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.base.service.BaseService;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;
import uz.pdp.apprailwayapi.trains.repository.TrainRepository;
import uz.pdp.apprailwayapi.wagons.entity.WagonEntity;
import uz.pdp.model.ApiResponse;
import uz.pdp.model.train.TrainCreatedto;
import uz.pdp.model.wagon.WagonCreateDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrainService implements BaseService<TrainCreatedto, TrainsEntity> {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse add(TrainCreatedto trainReceiveDTO) {
        TrainsEntity train = modelMapper.map(trainReceiveDTO, TrainsEntity.class);
        if (trainRepository.existsByName(train.getName())) {
            return new ApiResponse("This train already exists", false);
        }
        trainRepository.save(train);
        return new ApiResponse("Train was saved", true);
    }

    @Override
    public TrainsEntity getById(Long id) {
        Optional<TrainsEntity> optional = trainRepository.findById(id);
        return optional.get();
    }

    @Override
    public List<TrainsEntity> get() {
        return trainRepository.findAll();
    }

    @Override
    public ApiResponse delete(TrainCreatedto trainReceiveDTO) {
        if (trainRepository.existsByName(trainReceiveDTO.getName())) {
            TrainsEntity map = modelMapper.map(trainReceiveDTO, TrainsEntity.class);
            trainRepository.delete(map);
            return new ApiResponse("Train was deleted", true);
        }
        return new ApiResponse("Train not found", false);
    }

    @Override
    public ApiResponse edit(Long id, TrainCreatedto trainReceiveDTO) {
        Optional<TrainsEntity> optional = trainRepository.findById(id);
        if (optional.isPresent()) {
            TrainsEntity train = optional.get();
            Set<WagonEntity> wagonEntities = trainReceiveDTO.getWagons().stream().map(wagonCreateDTO->modelMapper.map(wagonCreateDTO, WagonEntity.class)).collect(Collectors.toSet());
            train.setWagons(wagonEntities);
            trainRepository.save(train);
            return new ApiResponse("Train updated", true);
        }
        return new ApiResponse("Train not found", false);
    }
}