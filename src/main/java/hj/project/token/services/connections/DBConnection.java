package hj.project.token.services.connections;

public interface DBConnection {

    void startConnecting();
    void insertingHash(String token, String hash);
    String returningHash(String token);

}
