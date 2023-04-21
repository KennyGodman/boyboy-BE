package boyboy.project.boyboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@Profile("prod")
public class BoyBoyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoyBoyApplication.class, args);
    }

}
