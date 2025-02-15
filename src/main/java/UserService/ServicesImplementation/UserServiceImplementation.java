package UserService.ServicesImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import UserService.Entities.UserEntity;
import UserService.Repositories.IUserRepository;
import UserService.Services.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImplementation implements IUserService {

    @Autowired
    private IUserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<UserEntity> FindAll() throws Exception {
        try {
            List<UserEntity> Users = this.UserRepository.findAll();
            return Users;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public UserEntity FindById(Long Id_User) throws Exception {
        try {
            Optional<UserEntity> User = this.UserRepository.findById(Id_User);
            return User.get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public UserEntity Save(UserEntity User) throws Exception {
        User.setPassword(passwordEncoder.encode(User.getPassword()));
        try {
            UserEntity SaveUser = this.UserRepository.save(User);
            return SaveUser;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public UserEntity Update(Long Id_User, UserEntity User) throws Exception {
        try {
            Optional<UserEntity> UserOptional = this.UserRepository.findById(Id_User);
            UserEntity UpdateUser = UserOptional.get();
            UpdateUser = this.UserRepository.save(User);
            return UpdateUser;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean Delete(Long Id_User) throws Exception {
        try {
            if (this.UserRepository.existsById(Id_User)) {
                this.UserRepository.deleteById(Id_User);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
