package com.docker.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootDockerBuildApplication {



//    public static void main(String[] args) {
//        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
//        SpringApplication sa = new SpringApplication(ExampleMain.class);
//        sa.setAdditionalProfiles("remote","live");
//        sa.run(args);
//    }


    public static void main(String[] args) {
        String javaHome = System.getenv("RW_DEV");
        System.out.println("env ->" + javaHome);
        SpringApplication.run(SpringBootDockerBuildApplication.class, args);
    }

}
