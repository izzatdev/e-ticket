package uz.pdp.apprailwayapi.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.user.entity.UserEntity;
import uz.pdp.apprailwayapi.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
