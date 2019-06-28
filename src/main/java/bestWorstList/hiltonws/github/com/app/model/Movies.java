package bestWorstList.hiltonws.github.com.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    private String producers;
    private Integer year;
    private String title;
    private String studios;
    private String winner;

}
