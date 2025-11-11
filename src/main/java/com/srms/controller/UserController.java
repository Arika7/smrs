package com.srms.controller;


import com.srms.dto.UserSearchDto;
import com.srms.model.User;
import com.srms.repository.UserRepository;
import com.srms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByid(@PathVariable Long id){
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserSearchDto>> searchUsers(@RequestParam String keyword){
        List<UserSearchDto> results = userRepository.searchUsers(keyword).stream().map(p ->
                new UserSearchDto(
                        p.getId(),
                        p.getFullName(),
                        p.getEmail(),
                        p.getStatus().name()
                )).toList();

        return ResponseEntity.ok(results);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
       User updatedUser = userService.updateUser(id, userDetails);

       return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        userService.deleteUser(id);

        return ResponseEntity.ok().build();
    }
}
