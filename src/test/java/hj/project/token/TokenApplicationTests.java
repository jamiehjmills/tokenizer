package hj.project.token;

import hj.project.token.connections.PostgresConnection;
import hj.project.token.services.hashing.Base64Hash;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
class TokenApplicationTests {

    @Autowired
    PostgresConnection postgresConnection;
    @Autowired
    Base64Hash hashCreator;
    @Test
    void contextLoads() throws NoSuchAlgorithmException {
       // postgresConnection.startConnecting();
       String hash = hashCreator.encode("test");
       hashCreator.decode(hash);
    }

}
