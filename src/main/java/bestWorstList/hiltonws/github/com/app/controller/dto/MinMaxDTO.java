package bestWorstList.hiltonws.github.com.app.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class MinMaxDTO {
    private List<MoviesDTO> min;
    private List<MoviesDTO> max;
}
