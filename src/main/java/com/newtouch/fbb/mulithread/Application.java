package com.newtouch.fbb.mulithread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by steven on 2018/1/11.
 */
@SpringBootApplication(exclude = {FreeMarkerAutoConfiguration.class})
@ComponentScan(basePackages = "com.newtouch")
@RestController
@EnableSwagger2
public class Application {

    public static void main(String arg[]){

        SpringApplication application = new SpringApplication(Application.class);
        application.run(arg);
    }

    @RequestMapping(value = "/hs",method = RequestMethod.GET)
    public String healthyCheck(){
        return "System is running";
    }

}
