package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.UserDto;
import pl.coderslab.errorhandler.exception.EntityNotFoundException;
import pl.coderslab.impl.UserServiceImpl;
import pl.coderslab.model.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRESTController {

    private final UserServiceImpl userService;

    @Autowired
    public UserRESTController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping("/find/{id}")
    public UserDto getUserById(@PathVariable(value = "id") Long userId) throws EntityNotFoundException {
        return userService.findById(userId);
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@PathVariable(value = "id") Long userId,
                             @Valid @RequestBody User userDetails) throws EntityNotFoundException {
        UserDto foundedUser = userService.findById(userId);
        if (foundedUser != null) {
            foundedUser.setUsername(userDetails.getUsername());
            foundedUser.setPassword(userDetails.getPassword());
            return userService.saveUser(foundedUser);
        }
        throw new ResourceNotFoundException("User not found for this id: " + userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        userService.removeById(id);
    }

    @GetMapping("/findAll")
    public List<UserDto> getAllUsers() throws EntityNotFoundException {
        return userService.findAll();
    }

}