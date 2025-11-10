package com.srms.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String noteText;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_user_id", nullable = false)
    private User targetUser;
}
