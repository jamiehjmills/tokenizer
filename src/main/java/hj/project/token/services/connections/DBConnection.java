package hj.project.token.services.connections;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface DBConnection {

    void startConnecting();
    void insertingHash(String token, String hash);
    List<String> returningHash(String token);

}
