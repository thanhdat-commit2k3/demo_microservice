package com.thanhdat.user_service.controller;

import com.thanhdat.user_service.model.User;
import com.thanhdat.user_service.dto.UserDto;
import com.thanhdat.user_service.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable("id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
