package uz.pdp.apprailwayapi.stations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.apprailwayapi.stations.entity.StationsEntity;

import java.util.Optional;

@Repository
public interface StationsRepository extends JpaRepository<StationsEntity, Long> {
    Optional<StationsEntity> findByName(String name);
    boolean existsByName(String name);

}
