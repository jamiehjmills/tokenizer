package hj.project.token.services;

import hj.project.token.configs.TokenDb;
import hj.project.token.connections.PostgresConnection;
import hj.project.token.services.hashing.Base64Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Tokenizer extends MainTokenizer{

    private static final Logger logger = LoggerFactory.getLogger(Tokenizer.class);

    public Tokenizer(){

        dbConnection = new PostgresConnection();
        hashing = new Base64Hash();

    }

    @Override
    public String process(String input) {

        String encodedInput = hashing.encode(input);

        return encodedInput;

    }

}
