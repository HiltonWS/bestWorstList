package bestWorstList.hiltonws.github.com.core.generic;

import com.google.common.base.Preconditions;
import bestWorstList.hiltonws.github.com.core.generics.DefaultEntity;
import bestWorstList.hiltonws.github.com.core.generics.DefaultRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class DefaultService<T extends DefaultEntity, R extends DefaultRepositoy<T, Long>> implements IServiceListener<T> {

    @Autowired
    protected R repository;

    public Long create( T t){
        Preconditions.checkNotNull(t);
        onCreate();
        return repository.save(t).getId();
    }

    public Page<T> list(Pageable pageable){
        onList();
        return repository.findAll(pageable);
    }

    public Page<T> list(T t, Pageable pageable){
        onList();
        return repository.findAll(Example.of(t), pageable);
    }

    public List<T> list(){
        onList();
        return repository.findAll();
    }

    public List<T> list(T t){
        onList();
        return repository.findAll(Example.of(t));
    }

    public void remove(Long id){
        onRemove();
        repository.delete(id);
    }
    public T get(Long id){
        return repository.getOne(id);
    }
}
