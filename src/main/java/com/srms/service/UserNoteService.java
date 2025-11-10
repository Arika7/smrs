package com.srms.service;


import com.srms.model.User;
import com.srms.model.UserNote;
import com.srms.repository.UserNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserNoteService {

    private final UserNoteRepository userNoteRepository;

    public List<UserNote> findAll(){
        return userNoteRepository.findAll();
    }

    public Optional<UserNote> findById(Long id){
        return userNoteRepository.findById(id);
    }

    public UserNote save(UserNote note) {
        return userNoteRepository.save(note);
    }

    public void deleteById(Long id) {
        userNoteRepository.deleteById(id);
    }

    public List<UserNote> findByAuthorId(Long authorId) {
        return userNoteRepository.findByAuthorId(authorId);
    }

    public List<UserNote> findByTargetUserId(Long targetUserId) {
        return userNoteRepository.findByTargetUserId(targetUserId);
    }
}
