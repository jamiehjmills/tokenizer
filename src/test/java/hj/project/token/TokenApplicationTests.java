package hj.project.token;

import hj.project.token.services.MainTokenizer;
import hj.project.token.services.Tokenize;
import hj.project.token.services.TokenizerService;
import hj.project.token.services.connections.PostgresConnection;
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

    @Autowired
    TokenizerService tokenizerService;

    @Autowired
    Tokenize tokenize;

    @Test
    void hashingTest() throws NoSuchAlgorithmException {
       // postgresConnection.startConnecting();
       String hash = hashCreator.encode("test");
       hashCreator.decode(hash);
    }

    @Test
    void postgresConnectionTest(){
        postgresConnection.startConnecting();
        //postgresConnection.insertingHash("3334", "hi");
        System.out.println(postgresConnection.returningHash("3334"));
    }

    @Test
    void tokenizerTest(){ //no user can customise DB and Hash
        tokenizerService.init();
        tokenizerService.encode("testtt");

    }

    @Test
    void tokenizerTest2(){ //user can customise DB and Hash

        tokenize = new Tokenize(postgresConnection, hashCreator);

        tokenize.init();
        //tokenizer.encode("testt");
        //tokenize.decode("1234");
        String list = "testt";
        System.out.println(tokenize.creatingToken(list.toCharArray()));


    }

    @Test
    void testingForAnything(){

        int big = 'A';
        int small = 'a';

        System.out.println(big);
        System.out.println(small);


    }

}
