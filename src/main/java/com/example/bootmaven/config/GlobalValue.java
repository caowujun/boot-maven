package com.example.bootmaven.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author robin
 * @date 2022年06月29日 16:42
 * @description
 */
//@PropertySource("classpath:application.properties")
@Component
@Data
//@ConfigurationProperties(prefix = "globle")
public class GlobalValue {

    @Value("${globle.token.secret}")
    private String tokenSecret;

    @Value("${globle.token.expiretime}")
    private String tokenExpiretime;


    public byte[] getTokenSecret() {
        return tokenSecret.getBytes();
    }
}
