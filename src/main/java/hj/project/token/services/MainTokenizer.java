package hj.project.token.services;

import hj.project.token.connections.DBConnection;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class MainTokenizer {

    @Autowired
    DBConnection dbConnection;

    public void init(){
        dbConnection.startConnecting();
    }

}
