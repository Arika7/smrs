package com.srms.controller;


import com.srms.dto.DashboardResponse;
import com.srms.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashBoardService dashBoardService;

    @GetMapping
    public ResponseEntity<DashboardResponse> getDashBoard(){
        return ResponseEntity.ok(dashBoardService.buildDashboard());

    }


}
