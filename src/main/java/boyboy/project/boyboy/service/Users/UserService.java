package boyboy.project.boyboy.service.Users;

import boyboy.project.boyboy.data.dtos.request.UserRegistrationRequest;
import boyboy.project.boyboy.data.dtos.response.Response;

public interface UserService {

    Response register(UserRegistrationRequest userRegistrationRequest);
}
