package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
    @Getter
    @Setter
    @NotEmpty
    private long seance;

    @Column(name = "rep_min")
    @Getter
    @Setter
    private int rep_min;

    @Column(name = "rep_max")
    @Getter
    @Setter
    @NotEmpty
    private int rep_max;

    @Column(name = "nb_serie")
    @Getter
    @Setter
    @NotEmpty
    private int nb_serie;

    @Column(name = "vma_max")
    @Getter
    @Setter
    @NotEmpty
    private int vma_max;

    @Column(name = "pourcentage_vma")
    @Getter
    @Setter
    @NotEmpty
    private int pourcentage_vma;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "seances")
    @Getter
    @Setter
    private List<Planning> planning;


    public Seance() {
    }

    public Seance(TypeSeance typeSeance, TypeCourse typeCourse, long seance, int rep_min, int rep_max, int nb_serie, int vma_max, int pourcentage_vma) {
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
