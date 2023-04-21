package boyboy.project.boyboy.data.models;

import jakarta.annotation.Generated;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Users {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String location;
    private String Service;
}
