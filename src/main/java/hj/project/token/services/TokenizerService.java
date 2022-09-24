package hj.project.token.services;

import hj.project.token.services.connections.PostgresConnection;
import hj.project.token.services.hashing.Base64Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenizerService {

    @Autowired
    PostgresConnection postgresConnection;

    @Autowired
    Base64Hash base64Hash;

    //Tokenizer tokenizer;
    MainTokenizer tokenizer;

    public void init(){

        //this.tokenizer = new Tokenizer(postgresConnection, base64Hash);
        //tokenizer.init();
        this.tokenizer= new Tokenize(postgresConnection, base64Hash);
        tokenizer.init();

    }

    public String encode(String value){
        return tokenizer.encode(value);
    }
}
