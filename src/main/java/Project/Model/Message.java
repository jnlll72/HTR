package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "contenu")
    @Getter
    @Setter
    @NotEmpty
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @CreationTimestamp
    @Column(name="created")
    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date created;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @Getter
    @Setter
    private Article article;

    public Message() {
    }

    public Message(long id, String contenu, User user, Article article) {
        this.id = id;
        this.contenu = contenu;
        this.user = user;
        this.article = article;
    }
}
