package uz.pdp.apprailwayapi.prices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.prices.entity.PricesEntity;


public interface PricesRepository extends JpaRepository<PricesEntity,Long> {

}
