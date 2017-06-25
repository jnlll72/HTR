package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Planning")
public class Planning implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @ManyToOne
    @JoinColumn(name = "typeCourse_id")
    @Getter
    @Setter
    private TypeCourse typeCourse;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @CreationTimestamp
    @Column(name = "date_debut")
    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date date_debut;

    @CreationTimestamp
    @Column(name = "date_fin")
    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date date_fin;

    @Column(name = "nb_semaine")
    @Getter
    @Setter
    @NotEmpty
    private int nb_semaine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "SeancePlanning", joinColumns = {
            @JoinColumn(name = "planning_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "seance_id",
                    nullable = false, updatable = false)})
    @Getter
    @Setter
    private List<Seance> seances;

    public Planning() {
    }

    public Planning(TypeCourse typeCourse, User user, Date date_debut, Date date_fin, int nb_semaine) {
        this.typeCourse = typeCourse;
        this.user = user;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_semaine = nb_semaine;
    }
}
