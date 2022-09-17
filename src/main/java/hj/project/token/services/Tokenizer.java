package hj.project.token.services;

import hj.project.token.configs.ConfigProperties;
import hj.project.token.configs.TokenDb;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Tokenizer implements MainTokenizer{

    @Autowired
    ConfigProperties configProp;

    @Autowired
    TokenDb tokenDb;

    @PostMapping("/test")
    public String getFoos(@RequestParam String id) {
        System.out.println("ID: " + tokenDb.getDb()); //works
        System.out.println(configProp.getConfigValue(("token.db"))); //works
        return id;
    }

    @Override
    public void init() {

    }

    public String returnToken(String value) {
        return null;
    }

}
