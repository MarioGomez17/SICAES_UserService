package UserService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UserService.Entities.IdentificationTypeEntity;

@Repository
public interface IIdentificationTypeRepository extends JpaRepository<IdentificationTypeEntity, Long> {

}