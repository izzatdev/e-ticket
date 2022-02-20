package uz.pdp.apprailwayapi.seats.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.seats.entity.SeatsEntity;
import uz.pdp.apprailwayapi.seats.repository.SeatsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatsService {
    private final SeatsRepository seatsRepository;

    public List<SeatsEntity> getAllSeats() {
        return seatsRepository.findAll();
    }
}

