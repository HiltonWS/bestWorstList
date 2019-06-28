package bestWorstList.hiltonws.github.com.tests;

import bestWorstList.hiltonws.github.com.app.controller.MoviesController;
import bestWorstList.hiltonws.github.com.app.service.MoviesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesControllerIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private MoviesController controller;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();// Standalone context

    }

    @Test
    public void testHasControllerWithServiceWithRepositoryWithMethodGET() throws Exception {
        mockMvc.perform(get("/movies").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
