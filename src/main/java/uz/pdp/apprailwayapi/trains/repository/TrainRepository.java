package uz.pdp.apprailwayapi.trains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.trains.entity.TrainsEntity;

import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<TrainsEntity, Long> {
    Optional<TrainsEntity> findByName(String Name);
    Optional<TrainsEntity> findById(Long id);

}
