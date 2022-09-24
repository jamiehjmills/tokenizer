package hj.project.token.services;

import hj.project.token.services.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;

public class DeTokenizer extends MainTokenizer{

    public DeTokenizer(DBConnection dbConnection, Hashing hashing) {
        super(dbConnection, hashing);
    }

    @Override
    public String process(String token) {
        return null;
    }
}
