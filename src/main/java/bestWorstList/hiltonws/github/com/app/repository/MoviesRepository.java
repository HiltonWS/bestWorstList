package bestWorstList.hiltonws.github.com.app.repository;

import bestWorstList.hiltonws.github.com.app.controller.dto.MovieDTO;
import bestWorstList.hiltonws.github.com.app.model.Movies;
import bestWorstList.hiltonws.github.com.core.generics.DefaultRepositoy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends DefaultRepositoy<Movies, Long> {

    //Para maior quantidade de dados melhor tratar pelo java com segmentação, ou usar outro processo
    @Query("SELECT new bestWorstList.hiltonws.github.com.app.controller.dto.MovieDTO(m.producers, MAX(CAST(m.year AS integer)) - MIN(CAST(m.year AS integer)), MIN(CAST(m.year AS integer)), MAX(CAST(m.year AS integer))) " +
            "FROM Movies  as m WHERE winner = 'yes' GROUP BY producers HAVING MAX(CAST(m.year AS integer)) - MIN(CAST(m.year AS integer)) > 0 ORDER BY MAX(CAST(m.year AS integer)) - MIN(CAST(m.year AS integer)) ASC")
    List<MovieDTO> min();
    @Query("SELECT new bestWorstList.hiltonws.github.com.app.controller.dto.MovieDTO(m.producers, MAX(CAST(m.year AS integer)) - MIN(CAST(m.year AS integer)), MIN(CAST(m.year AS integer)), MAX(CAST(m.year AS integer))) " +
            "FROM Movies  as m WHERE winner = 'yes' GROUP BY producers HAVING MAX(CAST(m.year AS integer)) - MIN(CAST(m.year AS integer)) > 0 ORDER BY MAX(CAST(m.year AS integer)) - MIN(CAST(m.year AS integer)) DESC")
    List<MovieDTO> max();
}
