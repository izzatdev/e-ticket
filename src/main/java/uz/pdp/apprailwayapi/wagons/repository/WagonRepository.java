package uz.pdp.apprailwayapi.wagons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.wagons.entity.WagonEntity;

public interface WagonRepository extends JpaRepository<WagonEntity, Long> {
}
