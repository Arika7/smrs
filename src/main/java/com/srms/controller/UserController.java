package com.srms.controller;


import com.srms.model.User;
import com.srms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String keyword){
        List<User> users = userService.searchUsers(keyword);
        return ResponseEntity.ok(users);

    }
}
