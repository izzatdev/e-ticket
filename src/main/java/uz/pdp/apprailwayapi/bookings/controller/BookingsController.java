package uz.pdp.apprailwayapi.bookings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;
import uz.pdp.apprailwayapi.bookings.service.BookingsService;
import uz.pdp.apprailwayapi.user.entity.UserEntity;
import uz.pdp.apprailwayapi.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingsController {
    private final BookingsService bookingsService;

    @GetMapping
    public ResponseEntity<?> getAllBookings() {
        List<BookingsEntity> allBookings = bookingsService.getAllBookings();
        return ResponseEntity.ok(allBookings);

    }
}
