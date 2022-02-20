package uz.pdp.apprailwayapi.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.bookings.entity.BookingsEntity;


public interface BookingsRepository extends JpaRepository<BookingsEntity,Long> {

}
