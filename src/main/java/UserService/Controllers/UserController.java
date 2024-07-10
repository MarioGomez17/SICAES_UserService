package UserService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UserService.Entities.UserEntity;
import UserService.ServicesImplementation.UserServiceImplementation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/sicaes/api/user")
public class UserController {

    @Autowired
    private UserServiceImplementation UserService;

    @GetMapping("/GetAllUsers")
    public ResponseEntity<?> GetAllUsers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.UserService.FindAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @GetMapping("/GetUser/{Id_User}")
    public ResponseEntity<?> GetUser(@PathVariable Long Id_User) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.UserService.FindById(Id_User));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @PostMapping("/SaveUser")
    public ResponseEntity<?> SaveUser(@RequestBody UserEntity User) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.UserService.Save(User));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @PutMapping("/UpdateUser/{Id_User}")
    public ResponseEntity<?> UpdateUser(@PathVariable Long Id_User, @RequestBody UserEntity User) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.UserService.Update(Id_User, User));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @DeleteMapping("/DeleteUser/{Id_User}")
    public ResponseEntity<?> DeleteUser(@PathVariable Long Id_User) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.UserService.Delete(Id_User));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

}
