package com.srms.service;

import com.srms.model.User;
import com.srms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;


    public User saveUser(User user){

        return userRepo.save(user);
    }

    public User updateUser(Long id, User newUser){
        Optional<User> user1 = userRepo.findUserById(id);

        if(user1.isPresent()) {
            User user = user1.get();
            user1.get().setStatus(newUser.getStatus());
            return userRepo.save(user);
        } else throw new RuntimeException("Employee not found");
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }


    public List<User> searchUsers(String keyword){
        if(keyword == null || keyword.trim().isEmpty()){
            return new ArrayList<>();
        }
        return userRepo.searchUsers(keyword);

    }



}
