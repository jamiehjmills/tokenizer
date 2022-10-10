package hj.project.token.services;

import hj.project.token.services.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import org.springframework.stereotype.Component;

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

    public String decode(String token) {
        String hash = dbConnection.returningHash(token);
        return hashing.decode(token, hash);
    }
}
