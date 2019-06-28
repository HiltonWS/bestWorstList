package bestWorstList.hiltonws.github.com.app.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDTO {
    private String producer;
    private Integer interval;
    private Integer previsiousWin;
    private Integer followingWin;
}
