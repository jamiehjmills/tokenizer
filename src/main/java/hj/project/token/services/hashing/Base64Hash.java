package hj.project.token.services.hashing;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

/*
Base64 Java encode and decode a string
 */
@Service
public class Base64Hash implements Hashing {

    @Override
    public String encode(String input) {
        byte[] bytesEncoded = Base64.encodeBase64(input.getBytes());
        return new String(bytesEncoded);
    }

    @Override
    public String decode(String valueEncoded) {
        byte[] valueDecoded = Base64.decodeBase64(valueEncoded);
        return new String(valueDecoded);
    }

}

