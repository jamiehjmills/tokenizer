package hj.project.token.configs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix="token")
public class TokenDb {

    String db;
    String host;
    String port;
    String url;
    String schema;
    String table;
    String user;
    String pw;

}
