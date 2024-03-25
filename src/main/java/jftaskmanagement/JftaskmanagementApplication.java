package jftaskmanagement;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("jftaskmanagement.model")
public class JftaskmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(JftaskmanagementApplication.class, args);
    }
}
