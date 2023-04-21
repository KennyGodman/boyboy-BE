package boyboy.project.boyboy.utils.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

@Configuration
@EnableMongoRepositories
@Profile("prod")
public class ProdDatabaseConfig {

    @Value("${PROD.DB.HOST}")
    private String host;

    @Value("${PROD.DB.PORT}")
    private int port;

    @Value("${PROD.DB.NAME}")
    private String databaseName;

    @Value("${PROD.DB.USERNAME}")
    private String username;

    @Value("${PROD.DB.PASSWORD}")
    private String password;

    @Bean
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(username, databaseName, password.toCharArray());
        ServerAddress serverAddress = new ServerAddress(host, port);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Collections.singletonList(serverAddress)))
                .credential(credential)
                .build();
        return MongoClients.create(settings);
    }

}

