package bestWorstList.hiltonws.github.com.app.model;

import bestWorstList.hiltonws.github.com.core.generics.DefaultEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table
public class Movies extends DefaultEntity implements Serializable {

    private String producers;
    //Em dados reais poderia usar um Integer, ou Long para evitar casts
    private String year;
    private String title;
    private String studios;
    //Também poderia usar boolean
    private String winner;

}
