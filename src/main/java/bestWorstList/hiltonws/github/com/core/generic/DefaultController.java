package bestWorstList.hiltonws.github.com.core.generic;

import bestWorstList.hiltonws.github.com.core.generics.DefaultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class DefaultController<T extends DefaultService, E extends DefaultEntity> {

    @Autowired
    protected T service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody E entidade) {
        return service.create(entidade);
    }

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<T> list(@RequestParam Pageable pageable, @RequestParam E param) {
        return service.list(param, pageable);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void remove(@RequestParam Long id) {
        service.remove(id);
    }
}
