package com.srms.service;

import com.srms.model.User;
import com.srms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public List<User> searchUsers(String keyword){
        if(keyword == null || keyword.trim().isEmpty()){
            return new ArrayList<>();
        }
        return userRepo.searchUsers(keyword);

    }

}
