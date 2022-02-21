package uz.pdp.apprailwayapi.passengers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.passengers.entity.PassengersEntity;
import uz.pdp.apprailwayapi.passengers.repository.PassengersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengersService {
    private final PassengersRepository passengersRepository;

    public List<PassengersEntity> getAllPassengers() {
        return passengersRepository.findAll();
    }
}

