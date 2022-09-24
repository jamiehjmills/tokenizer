package hj.project.token.services;

import hj.project.token.connections.DBConnection;
import hj.project.token.services.hashing.Hashing;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class MainTokenizer {

    @Autowired
    DBConnection dbConnection;

    @Autowired
    Hashing hashing;

    public void init(){
        dbConnection.startConnecting();
    }

}
