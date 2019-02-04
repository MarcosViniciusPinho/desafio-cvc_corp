package integration;

import com.cvc.corp.desafio.DesafioApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcos Pinho
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DesafioApplication.class
)
@AutoConfigureMockMvc
public class IntegrationSource {
}