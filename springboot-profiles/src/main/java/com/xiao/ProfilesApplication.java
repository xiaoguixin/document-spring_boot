package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 演示profiles的使用
 */
@SpringBootApplication
public class ProfilesApplication {

    public static void main(String[] args) {
        int type = 0;
        switch (type){
            case 1:// 程序来设置环境
                SpringApplication application = new SpringApplication(ProfilesApplication.class);
                application.setAdditionalProfiles();
                application.run(args);
                break;
            default:
                SpringApplication.run(ProfilesApplication.class, args);
                break;
        }
    }
}
