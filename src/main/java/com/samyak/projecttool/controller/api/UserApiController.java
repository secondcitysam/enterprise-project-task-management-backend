package com.samyak.projecttool.controller.api;

import com.samyak.projecttool.entity.User;
import com.samyak.projecttool.entity.enums.UserStatus;
import com.samyak.projecttool.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    private final UserRepository userRepository;

    public UserApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Simple user creation (bootstrap purpose).
     * No password, no auth – intentional.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String name,
                                           @RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setStatus(UserStatus.ACTIVE);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userRepository.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
