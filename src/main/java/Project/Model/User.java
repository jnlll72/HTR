package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @NotEmpty
    @Column(name = "nom")
    @Getter
    @Setter
    private String nom;

    @NotEmpty
    @Column(name = "prenom")
    @Getter
    @Setter
    private String prenom;

    @NotEmpty
    @Column(name = "email")
    @Getter
    @Setter
    @Email(message = "Email non valide")
    private String email;

    @NotEmpty
    @Column(name = "pwd")
    @Size(min = 4, max = 255, message = "Le mot de passe doit contenir plus de 4 caracteres")
    @Getter
    @Setter
    private String pwd;

    public User() {
    }

    public User(String nom, String prenom, String email, String pwd) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pwd = pwd;
    }
}
