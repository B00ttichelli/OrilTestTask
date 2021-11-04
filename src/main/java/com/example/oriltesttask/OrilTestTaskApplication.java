package com.example.oriltesttask;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrilTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrilTestTaskApplication.class, args);
    }

}
