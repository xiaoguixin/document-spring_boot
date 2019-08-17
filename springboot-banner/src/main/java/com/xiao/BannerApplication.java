package com.xiao;

import javafx.scene.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 演示banner的用法
 * 需要将banner放到resources目录
 */
@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
        int runType = 2;
        switch (runType){
            case 1 :
                SpringApplication app = new SpringApplication(BannerApplication.class);

                // Banner.Mode：console输出到控制台 off关闭输出
                app.setBannerMode(Banner.Mode.CONSOLE);
                //app.addListeners();
                app.run();
                break;
            case 2 :
                new SpringApplicationBuilder()
                        .sources(Parent.class)
                        .child(BannerApplication.class)
                        .bannerMode(Banner.Mode.CONSOLE)
                        //.listeners()
                        .run(args);
                break;
            default:
                SpringApplication.run(BannerApplication.class, args);
        }




    }
}
