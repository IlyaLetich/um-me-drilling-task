package by.upmebel.upmecutfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UpMeDrillingApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpMeDrillingApplication.class, args);
    }
}