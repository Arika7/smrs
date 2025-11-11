package com.srms.dto;

import com.srms.model.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StatusChangeRequest {
    @NotBlank
    private Status status;

    private Long userId;

    private String comment;

    private Integer brbMins;
}
