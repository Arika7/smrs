package com.srms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSummary {

    private Long id;
    private String fullName;
    private String status;
    private String comment;
    private LocalDateTime breakStartTime;
    private LocalDateTime breakEndTime;
}
