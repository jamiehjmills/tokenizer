package hj.project.token.services.hashing;

public interface Hashing {

    public String encode(String input);

    public String decode(String input);
}
