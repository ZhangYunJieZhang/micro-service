package com.zyj.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OauthServerApplication {

    /**
     *
     * get获取code
     * http://127.0.0.1:8080/oauth/authorize?client_id=mayikt_appid&response_type=code
     *
     * post获取token
     * http://localhost:8080/oauth/token?code=fLMn2f&grant_type=authorization_code&redirect_uri=http://www.mayikt.com/callback&scope=all&client_id=mayikt_appid&client_secret=mayikt_pwd
     *
     * 刷新token
     * http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=fbde81ee-f419-42b1-1234-9191f1f95be9&client_id=demoClientId&client_secret=demoClientSecret
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class, args);
    }

}
