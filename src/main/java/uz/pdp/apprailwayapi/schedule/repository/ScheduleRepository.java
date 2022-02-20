package uz.pdp.apprailwayapi.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.schedule.entity.ScheduleEntity;


public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {

}
