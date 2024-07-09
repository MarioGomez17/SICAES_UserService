package UserService.Models;

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
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_User")
    private Long Id_User;

    @Column(name = "FirstName_User")
    @Nonnull
    private String FirstName_User;

    @Column(name = "SecondName_User")
    @Nullable
    private String SecondName_User;

    @Column(name = "FirstLastName_User")
    @Nonnull
    private String FirstLastName_User;

    @Column(name = "SecondLastName_User")
    @Nullable
    private String SecondLastName_User;

    @ManyToOne
    @JoinColumn(name = "IdentificationType_User")
    private IdentificationTypeModel IdentificationType_User;

    @Column(name = "IdentificationNumber_User")
    @Nonnull
    private Long IdentificationNumber_User;

    @Column(name = "Password_User")
    @Nonnull
    private String Password_User;

    @Column(name = "BirthDate_User")
    @Nonnull
    private Date BirthDate_User;
}
