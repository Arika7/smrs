package com.srms.repository.projection;

import com.srms.model.Status;

public interface UserSearchProjection {

    Long getId();
    String getFullName();
    String getEmail();
    Status getStatus();
}
