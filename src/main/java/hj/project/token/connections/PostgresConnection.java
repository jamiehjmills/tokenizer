package hj.project.token.connections;

import hj.project.token.configs.ConfigProperties;
import hj.project.token.configs.TokenDb;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class PostgresConnection implements DBConnection{

    @Autowired
    ConfigProperties configProp;

    @Autowired
    TokenDb tokenDb;

    private static final Logger logger = LoggerFactory.getLogger(PostgresConnection.class);

    @Override
    @SneakyThrows
    public void connection() {

        Connection tokenConn = DriverManager.getConnection(tokenDb.getUrl(), tokenDb.getUser(), tokenDb.getPw());

        logger.info("Connecting...");


    }



}
