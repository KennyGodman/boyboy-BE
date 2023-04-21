package boyboy.project.boyboy.service.Users;

import boyboy.project.boyboy.data.dtos.request.UserRegistrationRequest;
import boyboy.project.boyboy.data.dtos.response.Response;
import boyboy.project.boyboy.data.repositories.UserRepository;
import boyboy.project.boyboy.utils.exceptions.InvalidDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImpTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void deleteAll(){
        userRepository.deleteAll();
    }

    @Test
    public void testThatUserCanRegister(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("Jennifer",
                "Musah", "jennymusah99@gmail.com", "09090997879","Gbaja road, 123", "Cleaning");
       Response response = userService.register(userRegistrationRequest);
       assertEquals("User registered successfully", response.getMessage());
    }
    @Test
    public void testThatExceptionIsThrownWhenWrongEmailFormatIsSent(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("Jennifer",
                "Musah", "jennymgmail.com", "09090997879","Gbaja road, 123", "Cleaning");
        assertThrows(InvalidDetails.class, () -> userService.register(userRegistrationRequest));
    }
    @Test
    public void testThatExceptionIsThrownWhenWrongPhoneNumberFormatIsSent(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("Jennifer",
                "Musah", "jennymusah99@gmail.com", "*75876993@#997879","Gbaja road, 123", "Cleaning");
        assertThrows(InvalidDetails.class, () -> userService.register(userRegistrationRequest));
    }

}
