package com.srms.dto;


import com.srms.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private Map<String, List<UserSummary>> platforms;
    private List<UserSummary> bottomPanel;
}
