package uz.pdp.apprailwayapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.apprailwayapi.user.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
