package com.lastSoftware.FirstProfessionalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ReklamcilikApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReklamcilikApplication.class, args);
    }
}
