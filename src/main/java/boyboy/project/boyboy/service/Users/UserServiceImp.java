package boyboy.project.boyboy.service.Users;

import boyboy.project.boyboy.data.dtos.request.UserRegistrationRequest;
import boyboy.project.boyboy.data.dtos.response.Response;
import boyboy.project.boyboy.data.models.Users;
import boyboy.project.boyboy.data.repositories.UserRepository;
import boyboy.project.boyboy.utils.exceptions.InvalidDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override public Response register(UserRegistrationRequest userRegistrationRequest) {
        Users existingUser = userRepository.findUsersByEmailAddress(userRegistrationRequest.getEmailAddress());
        if(existingUser != null) throw new InvalidDetails("User already exist");
        Users savedUser = createUser(userRegistrationRequest);
        return new Response("User registered successfully");
    }

    private Users createUser(UserRegistrationRequest userRegistrationRequest) {
        Users users = new Users();
        users.setEmailAddress(userRegistrationRequest.getEmailAddress());
        users.setFirstName(userRegistrationRequest.getFirstName());
        users.setLastName(userRegistrationRequest.getLastName());
        users.setLocation(userRegistrationRequest.getLocation());
        users.setService(userRegistrationRequest.getServices());
      return   userRepository.save(users);
    }

}
