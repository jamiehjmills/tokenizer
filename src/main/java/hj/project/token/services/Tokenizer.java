package hj.project.token.services;

import hj.project.token.configs.ConfigProperties;
import hj.project.token.configs.TokenDb;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Tokenizer extends MainTokenizer{

    @Autowired
    ConfigProperties configProp;

    @Autowired
    TokenDb tokenDb;

    private static final Logger logger = LoggerFactory.getLogger(Tokenizer.class);


    @PostMapping("/test")
    @SneakyThrows
    public String getFoos(@RequestParam String id){

        System.out.println("ID: " + tokenDb.getDb()); //works
        System.out.println(configProp.getConfigValue(("token.db"))); //works
        return id;

    }

    public String returnToken(String value) {
        return null;
    }

}
