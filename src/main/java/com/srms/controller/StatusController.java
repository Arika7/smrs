package com.srms.controller;


import com.srms.model.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusController {
    @GetMapping("/getAllStatuses")
    public ResponseEntity<List<String>> getStatuses(){
        List<String> statuses = Arrays.stream(Status.values()).map(Enum::name).toList();

        return ResponseEntity.ok(statuses);
    }
}
