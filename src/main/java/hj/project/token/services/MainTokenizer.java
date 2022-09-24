package hj.project.token.services;

import hj.project.token.services.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import org.springframework.beans.factory.annotation.Autowired;


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

    public abstract String process(String input);

}

//public interface MainTokenizer {
//
//    public void init();
//
//    public String process(String input);
//
//}
