package UserService.ServicesImplementation;

import java.util.List;
import java.util.Optional;

import UserService.Entities.IdentificationTypeEntity;
import UserService.Repositories.IIdentificationTypeRepository;
import UserService.Services.IIdentificationTypeService;
import jakarta.transaction.Transactional;

public abstract class IdentificationTypeImplementation implements IIdentificationTypeService {

    private IIdentificationTypeRepository IdentificationTypeRepository;

    @Override
    @Transactional
    public List<IdentificationTypeEntity> FindAll() throws Exception {
        try {
            List<IdentificationTypeEntity> IdentificationTypes = this.IdentificationTypeRepository.findAll();
            return IdentificationTypes;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public IdentificationTypeEntity FindById(Long Id_IdentificationType) throws Exception {
        try {
            Optional<IdentificationTypeEntity> IdentificationType = this.IdentificationTypeRepository.findById(Id_IdentificationType);
            return IdentificationType.get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public IdentificationTypeEntity Save(IdentificationTypeEntity IdentificationType) throws Exception {
        try {
            IdentificationTypeEntity SaveIdentificationType = this.IdentificationTypeRepository.save(IdentificationType);
            return SaveIdentificationType;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public IdentificationTypeEntity Update(Long Id_IdentificationType, IdentificationTypeEntity IdentificationType) throws Exception {
        try {
            Optional<IdentificationTypeEntity> IdentificationTypeOptional = this.IdentificationTypeRepository.findById(Id_IdentificationType);
            IdentificationTypeEntity UpdateIdentificationType = IdentificationTypeOptional.get();
            UpdateIdentificationType = this.IdentificationTypeRepository.save(IdentificationType);
            return UpdateIdentificationType;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean Delete(Long Id_IdentificationType) throws Exception {
        try {
            if (this.IdentificationTypeRepository.existsById(Id_IdentificationType)) {
                this.IdentificationTypeRepository.deleteById(Id_IdentificationType);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
