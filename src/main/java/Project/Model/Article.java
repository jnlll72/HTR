package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "sujet")
    @Getter
    @Setter
    @NotEmpty
    private String sujet;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    @Getter
    @Setter
    private Forum forum;

    @OneToMany(mappedBy = "article")
    @Getter
    @Setter
    private List<Message> messages;

    public Article() {
    }

    public Article(long id, String sujet, Forum forum) {
        this.id = id;
        this.sujet = sujet;
        this.forum = forum;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", sujet='" + sujet + '\'' +
                '}';
    }
}
