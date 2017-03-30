package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Seance")
public class Seance implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "seance")
    @Getter
    @Setter
    @NotEmpty
    private long seance;

    @ManyToOne
    @JoinColumn(name = "planning_id")
    @Getter
    @Setter
    private Planning planning;

    @ManyToOne
    @JoinColumn(name = "typeSeance_id")
    @Getter
    @Setter
    private TypeSeance typeSeance;

    public Seance() {
    }

    public Seance(long seance, Planning planning) {
        this.seance = seance;
        this.planning = planning;
    }
}
