package uz.pdp.apprailwayapi.trains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;

@Repository
public interface TrainRepository extends JpaRepository<TrainsEntity, Long> {
    boolean existsByName(String name);

}
