package com.example.SpringDocker.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User exsitingUser = userRepository.findById(id).get();
        exsitingUser.setName(user.getName());
        exsitingUser.setEmail(user.getEmail());
        return userRepository.save(exsitingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            Optional<User> existingUser = Optional.of(userRepository.findById(id).get());
            if (existingUser.isPresent()) {
                userRepository.deleteById(id);
            }
            return "User deleted successfully";
        } catch (Exception e) {
            return "User not found";
        }
    }
}
