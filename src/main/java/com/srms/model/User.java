package com.srms.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private LocalDateTime lastStatusUpdate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(fullName, user.fullName)  && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email);
    }

    private String userNotes;


    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
