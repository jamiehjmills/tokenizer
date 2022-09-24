package hj.project.token.services;

import hj.project.token.configs.ConfigProperties;
import hj.project.token.configs.TokenDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Tokenizer extends MainTokenizer{

    @Autowired
    ConfigProperties configProp;

    @Autowired
    TokenDb tokenDb;

    private static final Logger logger = LoggerFactory.getLogger(Tokenizer.class);

    public String returnToken(String value) {

        return null;

    }

}
