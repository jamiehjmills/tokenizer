package hj.project.token.services;

import hj.project.token.services.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tokenizer extends MainTokenizer{

    private static final Logger logger = LoggerFactory.getLogger(Tokenizer.class);

    @Autowired
    public Tokenizer(DBConnection dbConnection, Hashing hashing) {
        super(dbConnection, hashing);
    }


    @Override
    public void init() {

    }

    @Override
    public String process(String input) {

        //String encodedInput = hashing.encode(input);

        return null;

    }

}
