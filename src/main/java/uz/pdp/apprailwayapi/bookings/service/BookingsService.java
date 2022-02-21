package uz.pdp.apprailwayapi.bookings.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.bookings.repository.BookingsRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingsService {
    private final BookingsRepository bookingsRepository;

    public List<BookingsEntity> getAllBookings() {
        return bookingsRepository.findAll();
    }
}

