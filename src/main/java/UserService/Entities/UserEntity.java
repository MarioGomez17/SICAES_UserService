package UserService.Entities;

import java.io.Serializable;
import java.sql.Date;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_User")
    private Long id;

    @Column(name = "FirstName_User")
    @Nonnull
    private String firstName;

    @Column(name = "SecondName_User")
    @Nullable
    private String secondName;

    @Column(name = "FirstLastName_User")
    @Nonnull
    private String firstLastName;

    @Column(name = "SecondLastName_User")
    @Nullable
    private String secondLastName;

    @ManyToOne
    @JoinColumn(name = "IdentificationType_User")
    private IdentificationTypeEntity IdentificationType;

    @Column(name = "IdentificationNumber_User")
    @Nonnull
    private Long identificationNumber;

    @Column(name = "Password_User")
    @Nonnull
    private String password;

    @Column(name = "BirthDate_User")
    @Nonnull
    private Date birthDate;
}
