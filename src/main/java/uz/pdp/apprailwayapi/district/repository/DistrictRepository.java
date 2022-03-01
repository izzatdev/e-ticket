package uz.pdp.apprailwayapi.district.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.district.entity.DistrictEntity;

import java.util.Optional;


public interface DistrictRepository extends JpaRepository<DistrictEntity,Long> {
    Optional<DistrictEntity> findByName(String Name);

}
