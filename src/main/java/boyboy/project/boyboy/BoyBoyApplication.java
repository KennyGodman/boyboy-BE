package boyboy.project.boyboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BoyBoyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoyBoyApplication.class, args);
    }

}
