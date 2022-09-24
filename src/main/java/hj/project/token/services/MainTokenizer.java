package hj.project.token.services;

import hj.project.token.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public abstract class MainTokenizer {

    DBConnection dbConnection;
    Hashing hashing;

    public void init(){
        dbConnection.startConnecting();
    }

    public abstract String process(String input);

}
