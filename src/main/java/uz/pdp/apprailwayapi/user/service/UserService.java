package uz.pdp.apprailwayapi.user.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.apprailwayapi.exception.UserCustomException;
import uz.pdp.apprailwayapi.user.entity.UserEntity;
import uz.pdp.apprailwayapi.user.repository.UserRepository;
import uz.pdp.apprailwayapi.utils.ResponseUtils;
import uz.pdp.model.response.ApiResponse;
import uz.pdp.model.station.StationReceiveDTO;
import uz.pdp.model.user.UserLoginDTO;
import uz.pdp.model.user.UserReceiveDTO;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService extends ResponseUtils {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;


    public ApiResponse addUser(
            UserReceiveDTO userReceiveDTO
    ){
        checkUser(userReceiveDTO.getPhoneNumber());
        UserEntity userEntity = modelMapper.map(userReceiveDTO, UserEntity.class);
        userRepository.save(userEntity);
        return SUCCESS;
    }

    private void checkUser(String phoneNumber){
        Optional<UserEntity> optionalUserEntity = userRepository
                .findByPhoneNumber(phoneNumber);

        if (optionalUserEntity.isPresent())
            throw new UserCustomException(phoneNumber + " user is exist");
    }

    public ApiResponse getUserList(){
        return new ApiResponse(1,"success",userRepository.findAll());
    }


    public boolean checkUserPhoneNumber(
            String phoneNumber
    ){
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

    public boolean login(UserLoginDTO userLoginDTO){

        return userRepository.existsByPhoneNumberAndPassword(
                userLoginDTO.getEmail(),
                userLoginDTO.getPassword()
        );

    }
}