package boyboy.project.boyboy.data.repositories;

import boyboy.project.boyboy.data.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <Users, String> {

    Users findUsersByEmailAddress(String email);
}
