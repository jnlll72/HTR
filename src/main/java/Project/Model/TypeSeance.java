package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TypeSeance")
public class TypeSeance implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "short_name")
    @Getter
    @Setter
    @NotEmpty
    private String short_name;

    @Column(name = "long_name")
    @Getter
    @Setter
    @NotEmpty
    private String long_name;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    public TypeSeance() {
    }

    public TypeSeance(String short_name, String long_name, String description) {
        this.short_name = short_name;
        this.long_name = long_name;
        this.description = description;
    }
}
