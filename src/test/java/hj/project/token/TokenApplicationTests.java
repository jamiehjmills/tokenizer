package hj.project.token;

import hj.project.token.services.MainTokenizer;
import hj.project.token.services.Tokenize;
import hj.project.token.services.connections.PostgresConnection;
import hj.project.token.services.hashing.Base64Hash;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
@TestPropertySource(locations="classpath:application-token.properties")
class TokenApplicationTests {

    @Autowired
    PostgresConnection postgresConnection;
    @Autowired
    Base64Hash hashCreator;

    @Autowired
    MainTokenizer tokenize;

    @Test
    void tokenizeTest(){

        String original = "test";
        tokenize = new Tokenize(postgresConnection, hashCreator);
        tokenize.init();
        String token = tokenize.encode(original);
        Assert.assertEquals("3562157350-4-4", token);
        Assert.assertEquals(original,tokenize.decode(token));
    }


}
