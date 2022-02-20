package uz.pdp.apprailwayapi.seats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.seats.entity.SeatsEntity;


public interface SeatsRepository extends JpaRepository<SeatsEntity,Long> {

}
