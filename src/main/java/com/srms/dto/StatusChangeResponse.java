package com.srms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StatusChangeResponse {

    private Long userId;
    private String fullName;
    private String status;
    private LocalDateTime lastStatusUpdate;

}
