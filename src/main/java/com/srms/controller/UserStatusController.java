package com.srms.controller;


import com.srms.dto.StatusChangeRequest;
import com.srms.dto.StatusChangeResponse;
import com.srms.service.UserManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class UserStatusController {

    private final UserManagementService userManagementService;

    @PatchMapping("/changeStatus")
    public ResponseEntity<StatusChangeResponse> changeStatus(@RequestBody StatusChangeRequest request) {
        StatusChangeResponse response = userManagementService.changeStatus(request);
        return ResponseEntity.ok(response);
    }


}
