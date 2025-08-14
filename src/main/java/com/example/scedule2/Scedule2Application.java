package com.example.scedule2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Scedule2Application {

    public static void main(String[] args) {
        SpringApplication.run(Scedule2Application.class, args);
    }

}
