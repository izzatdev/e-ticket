package uz.pdp.apprailwayapi.passengers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.passengers.entity.PassengersEntity;


public interface PassengersRepository extends JpaRepository<PassengersEntity,Long> {

}
