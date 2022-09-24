package hj.project.token.services;

import hj.project.token.services.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class MainTokenizer {

    DBConnection dbConnection;
    Hashing hashing;

    @Autowired
    public MainTokenizer(DBConnection dbConnection, Hashing hashing){
        this.dbConnection = dbConnection;
        this.hashing = hashing;
    }

    public void init(){
        dbConnection.startConnecting();
    }

    public abstract String encode(String value);

    public abstract List<String> decode(String value);

}

