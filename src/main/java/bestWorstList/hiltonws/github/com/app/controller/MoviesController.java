package bestWorstList.hiltonws.github.com.app.controller;

import bestWorstList.hiltonws.github.com.app.controller.dto.MinMaxDTO;
import bestWorstList.hiltonws.github.com.app.model.Movies;
import bestWorstList.hiltonws.github.com.app.service.MoviesService;
import bestWorstList.hiltonws.github.com.core.generic.DefaultController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MoviesController extends DefaultController<MoviesService, Movies> {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MinMaxDTO get() {
        return service.get();
    }

}
