package UserService.Services;

import java.util.List;

import UserService.Entities.IdentificationTypeEntity;

public interface IIdentificationTypeService {

    public List<IdentificationTypeEntity> FindAll() throws Exception;

    public IdentificationTypeEntity FindById(Long Id_IdentificationType) throws Exception;

    public IdentificationTypeEntity Save(IdentificationTypeEntity User) throws Exception;

    public IdentificationTypeEntity Update(Long Id_IdentificationType, IdentificationTypeEntity User) throws Exception;

    public boolean Delete(Long Id_IdentificationType) throws Exception;

}
