package com.example.mymangausersystem;

import com.example.mymangausersystem.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class MyMangaUserSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMangaUserSystemApplication.class, args);
    }

}
