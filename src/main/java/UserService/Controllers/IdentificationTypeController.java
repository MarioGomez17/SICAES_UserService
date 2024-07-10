package UserService.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import UserService.Entities.IdentificationTypeEntity;
import UserService.ServicesImplementation.IdentificationTypeImplementation;

public class IdentificationTypeController {

    private IdentificationTypeImplementation IdentificationTypeService;

    @GetMapping("/GetAllIdentificationTypes")
    public ResponseEntity<?> GetAllIdentificationTypes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.IdentificationTypeService.FindAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @GetMapping("/GetIdentificationType/{Id_IdentificationType}")
    public ResponseEntity<?> GetIdentificationType(@PathVariable Long Id_IdentificationType) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.IdentificationTypeService.FindById(Id_IdentificationType));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @PostMapping("/SaveIdentificationType")
    public ResponseEntity<?> SaveIdentificationType(@RequestBody IdentificationTypeEntity IdentificationType) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.IdentificationTypeService.Save(IdentificationType));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @PutMapping("/UpdateIdentificationType/{Id_IdentificationType}")
    public ResponseEntity<?> UpdateIdentificationType(@PathVariable Long Id_IdentificationType, @RequestBody IdentificationTypeEntity IdentificationType) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.IdentificationTypeService.Update(Id_IdentificationType, IdentificationType));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }

    @DeleteMapping("/DeleteIdentificationType/{Id_IdentificationType}")
    public ResponseEntity<?> DeleteIdentificationType(@PathVariable Long Id_IdentificationType) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.IdentificationTypeService.Delete(Id_IdentificationType));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\" Error\":\"Error. Por favor intente más tarde\"}");
        }
    }
}
