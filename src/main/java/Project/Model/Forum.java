package Project.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Forum")
public class Forum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "titre")
    @Getter
    @Setter
    @NotEmpty
    private String titre;

    @OneToMany(mappedBy = "forum", fetch = FetchType.EAGER)
    @Getter
    @Setter
    private List<Article> articles;

    public Forum() {

    }

    public Forum(long id, String titre) {
        this.id = id;
        this.titre = titre;
        this.articles = new ArrayList<Article>();
    }
}
