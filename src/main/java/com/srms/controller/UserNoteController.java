package com.srms.controller;


import com.srms.model.UserNote;
import com.srms.service.UserNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class UserNoteController {
    private final UserNoteService userNoteService;

    @GetMapping("/byUser/{targetUserId}")
    public ResponseEntity<List<UserNote>> getNotesByTargetUser(@PathVariable Long targetUserId){
        return ResponseEntity.ok(userNoteService.findByTargetUserId(targetUserId));
    }

    @GetMapping("/byAuthor/{authorId}")
    public ResponseEntity<List<UserNote>> getNotesByAuthor(@PathVariable Long authorId){
        return ResponseEntity.ok(userNoteService.findByAuthorId(authorId));
    }

    @PostMapping
    public ResponseEntity<UserNote> createNote(@RequestBody UserNote note){
        note.setCreatedAt(LocalDateTime.now());
        UserNote saved = userNoteService.save(note);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        userNoteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
