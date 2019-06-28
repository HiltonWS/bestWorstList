package bestWorstList.hiltonws.github.com.app.service;

import bestWorstList.hiltonws.github.com.app.controller.dto.MinMaxDTO;
import bestWorstList.hiltonws.github.com.app.controller.dto.MovieDTO;
import bestWorstList.hiltonws.github.com.app.model.Movies;
import bestWorstList.hiltonws.github.com.app.repository.MoviesRepository;
import bestWorstList.hiltonws.github.com.core.generic.DefaultService;
import org.graalvm.util.CollectionsUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

@Service
public class MoviesService extends DefaultService<Movies, MoviesRepository> {


    @Override
    public void onCreate() {

    }

    @Override
    public void onList() {
    }

    @Override
    public void onRemove() {
    }

    public MinMaxDTO get() {
        MovieDTO max = CollectionUtils.isEmpty(repository.max()) ? null : repository.max().get(0);
        MovieDTO min = CollectionUtils.isEmpty(repository.min()) ? null : repository.min().get(0);
        MinMaxDTO dto = new MinMaxDTO();
        dto.setMax(max);
        dto.setMin(min);
        return dto;
    }
}
