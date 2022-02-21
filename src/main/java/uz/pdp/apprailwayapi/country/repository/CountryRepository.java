package uz.pdp.apprailwayapi.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.country.entity.CountryEntity;


public interface CountryRepository extends JpaRepository<CountryEntity,Long> {

}
