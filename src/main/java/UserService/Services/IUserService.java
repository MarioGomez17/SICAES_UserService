package UserService.Services;

import java.util.List;

import UserService.Entities.UserEntity;

public interface IUserService {

    public List<UserEntity> FindAll() throws Exception;

    public UserEntity FindById(Long Id_User) throws Exception;

    public UserEntity Save(UserEntity User) throws Exception;

    public UserEntity Update(Long Id_User, UserEntity User) throws Exception;

    public boolean Delete(Long Id_User) throws Exception;

}