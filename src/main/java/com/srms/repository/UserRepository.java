package com.srms.repository;


import com.srms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);


    @Query("SELECT u FROM User  u where lower(u.fullName) like lower(CONCAT('%', :keyword, '%') ) or " +
            "lower(u.email) like lower(concat('%', :keyword, '%') ) ")
    List<User> searchUsers(@Param("keyword") String keyword);

}
