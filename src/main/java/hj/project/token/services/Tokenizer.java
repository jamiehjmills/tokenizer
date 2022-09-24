package hj.project.token.services;

import hj.project.token.services.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Tokenizer{

    private static final Logger logger = LoggerFactory.getLogger(Tokenizer.class);

    DBConnection dbConnection;
    Hashing hashing;


    @Autowired
    public Tokenizer(DBConnection dbConnection, Hashing hashing) {

        this.dbConnection = dbConnection;
        this.hashing = hashing;

    }

    public void init(){

        dbConnection.startConnecting();

    }

    public String encode(String value){
        String hash = hashing.encode(value);
        // TODO: creating hash
        String token = "1234";
        dbConnection.insertingHash(token, hash);

        return token;
    }

    public List<String> decode(String token){
        List<String> listOfHash = dbConnection.returningHash(token);
        List<String> list = new ArrayList<>();

        //TODO: need to do something for listOfHash --> make sure it only returns one String
        for(String hash : listOfHash){
            String decodedValue = hashing.decode(hash);
            list.add(decodedValue);
        }

        return list;
    }
}
