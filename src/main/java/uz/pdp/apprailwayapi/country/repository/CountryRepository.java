package uz.pdp.apprailwayapi.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;
import uz.pdp.apprailwayapi.user.entity.UserEntity;

import java.util.Optional;


public interface CountryRepository extends JpaRepository<CountryEntity,Long> {
    Optional<CountryEntity> findByName(String Name);
}
