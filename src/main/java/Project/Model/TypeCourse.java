package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TypeCourse")
public class TypeCourse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "intitule")
    @Getter
    @Setter
    @NotEmpty
    private String intitule;

    public TypeCourse() {
    }

    public TypeCourse(String intitule) {
        this.intitule = intitule;
    }
}
