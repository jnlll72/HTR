package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Planning")
public class Planning implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    public Planning() {
    }

    public Planning(Date date_debut, Date date_fin, User user) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.user = user;
    }
}
