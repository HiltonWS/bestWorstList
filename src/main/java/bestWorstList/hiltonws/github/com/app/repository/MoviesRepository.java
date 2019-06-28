package bestWorstList.hiltonws.github.com.app.repository;

import bestWorstList.hiltonws.github.com.app.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {

}
