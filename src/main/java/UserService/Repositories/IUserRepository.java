package UserService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UserService.Entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
