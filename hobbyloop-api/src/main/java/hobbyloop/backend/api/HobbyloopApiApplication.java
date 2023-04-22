package hobbyloop.backend.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"hobbyloop.backend.domain","hobbyloop.backend.api"})
@EnableJpaRepositories(basePackages = "hobbyloop.backend.domain")
@EntityScan("hobbyloop.backend.domain")
@EnableJpaAuditing
public class HobbyloopApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(HobbyloopApiApplication.class, args);
    }
}
