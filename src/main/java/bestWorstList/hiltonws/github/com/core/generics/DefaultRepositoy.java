package bestWorstList.hiltonws.github.com.core.generics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultRepositoy<T extends DefaultEntity, E extends  Long> extends JpaRepository<T, E> {
}
