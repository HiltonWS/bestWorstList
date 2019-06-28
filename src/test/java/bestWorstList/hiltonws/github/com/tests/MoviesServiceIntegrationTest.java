package bestWorstList.hiltonws.github.com.tests;

import bestWorstList.hiltonws.github.com.app.service.MoviesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesServiceIntegrationTest {

    @Autowired
    private MoviesService service;

    @Test
    public void testHasServiceWithRepositoryWithMethodGET() {
        assertThat(service).isNotNull();
        assertThat(service.get()).isNotNull();
    }
}
