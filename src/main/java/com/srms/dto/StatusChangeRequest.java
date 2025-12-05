package com.srms.dto;

import com.srms.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatusChangeRequest {
    @NotNull
    private Status status;

    private Long userId;

    private String comment;

    private Integer brbMins;
}
