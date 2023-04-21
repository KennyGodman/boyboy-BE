package boyboy.project.boyboy.controller;

import boyboy.project.boyboy.data.dtos.request.UserRegistrationRequest;
import boyboy.project.boyboy.service.Users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest){
        return new ResponseEntity<>(userService.register(userRegistrationRequest), HttpStatus.OK);
    }

}
