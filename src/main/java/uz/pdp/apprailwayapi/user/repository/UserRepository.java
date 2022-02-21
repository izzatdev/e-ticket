package uz.pdp.apprailwayapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apprailwayapi.user.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
