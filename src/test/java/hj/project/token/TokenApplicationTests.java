package hj.project.token;

import hj.project.token.connections.PostgresConnection;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
class TokenApplicationTests {

    @Autowired
    PostgresConnection postgresConnection;
    @Test
    void contextLoads() {
        postgresConnection.connection();
    }

}
