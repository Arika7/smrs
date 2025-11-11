package com.srms.repository.projection;

import com.srms.model.Status;

import java.time.LocalDateTime;

public interface UserSummaryProjection {
    Long getId();
    String getFullName();
    Status getStatus();
    String getStatusComment();
    LocalDateTime getBreakStartTime();
    LocalDateTime getBreakEndTime();

}
