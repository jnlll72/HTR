package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Seance")
public class Seance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @ManyToOne
    @JoinColumn(name = "typeSeance_id")
    @Getter
    @Setter
    private TypeSeance typeSeance;

    @ManyToOne
    @JoinColumn(name = "typeCourse_id")
    @Getter
    @Setter
    private TypeCourse typeCourse;

    @Column(name = "seance")
    @DecimalMax("10000.0")
    @Getter
    @Setter
    @NotNull
    private long seance;

    @Column(name = "rep_min")
    @DecimalMax("20.0")
    @Getter
    @Setter
    private Integer rep_min;

    @Column(name = "rep_max")
    @DecimalMax("20.0")
    @Getter
    @Setter
    @NotNull
    private Integer rep_max;

    @Column(name = "nb_serie")
    @DecimalMax("10.0")
    @Getter
    @Setter
    @NotNull
    private Integer nb_serie;

    @Column(name = "vma_max")
    @DecimalMax("25.0")
    @Getter
    @Setter
    @NotNull
    private double vma_max;

    @Column(name = "pourcentage_vma")
    @DecimalMax("120.0")
    @Getter
    @Setter
    @NotNull
    private Integer pourcentage_vma;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "seances")
    @Getter
    @Setter
    private List<Planning> planning;


    public Seance() {
    }

    public Seance(TypeSeance typeSeance, TypeCourse typeCourse, long seance, Integer rep_min, Integer rep_max, Integer nb_serie, Integer vma_max, Integer pourcentage_vma) {
        this.typeSeance = typeSeance;
        this.typeCourse = typeCourse;
        this.seance = seance;
        this.rep_min = rep_min;
        this.rep_max = rep_max;
        this.nb_serie = nb_serie;
        this.vma_max = vma_max;
        this.pourcentage_vma = pourcentage_vma;
    }
}
