package hj.project.token.services.connections;

import org.springframework.stereotype.Repository;

public interface DBConnection {

    void startConnecting();
    void insertingHash(String token, String hash);

}
