package com.srms.repository.projection;

import com.srms.model.Status;

public interface UserSummaryProjection {
    Long getId();
    String getFullName();
    Status getStatus();

}
