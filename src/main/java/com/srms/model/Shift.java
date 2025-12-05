package com.srms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "shifts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform;         // Например: CS, PSR

    private Integer brbLimit;        // Лимит BRB в минутах (15/30)

    private LocalTime shiftStartTime; // Время начала смены (например, 09:00)

    private LocalTime shiftEndTime;   // Время конца смены (например, 18:00)

    private LocalTime breakTime;      // 🕒 Когда должен быть общий перерыв (например, 13:00)

    @OneToMany(mappedBy = "shift")
    private List<User> users;
}

