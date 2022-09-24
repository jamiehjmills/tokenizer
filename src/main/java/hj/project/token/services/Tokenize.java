package hj.project.token.services;

import hj.project.token.services.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tokenize extends MainTokenizer {

    public Tokenize(DBConnection dbConnection, Hashing hashing) {
        super(dbConnection, hashing);
    }

    @Override
    public String encode(String value) {

        String hash = hashing.encode(value);
        String token = creatingToken(hash.toCharArray());
        dbConnection.insertingHash(token, hash);

        return token;
    }

    public String creatingToken(char[] hash) {

        int[] listOfNums = new int[hash.length];
        StringBuilder sb = new StringBuilder(hash.length);

        for (int i = 0; i < hash.length; i++) {
            listOfNums[i] = hash[i] - 'A';
            sb.append(listOfNums[i]);
        }

        return sb.toString();
    }

    public List<String> decode(String token) {
        List<String> listOfHash = dbConnection.returningHash(token);
        List<String> list = new ArrayList<>();

        //TODO: need to do something for listOfHash --> make sure it only returns one String
        for (String hash : listOfHash) {
            String decodedValue = hashing.decode(hash);
            list.add(decodedValue);
        }

        return list;
    }
}
