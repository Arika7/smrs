package com.srms.repository;


import com.srms.model.UserNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNoteRepository extends JpaRepository<UserNote, Long> {

    List<UserNote> findByAuthorId (Long authorId);

    List<UserNote> findByTargetUserId(Long targetUserId);
}
