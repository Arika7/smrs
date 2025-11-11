package com.srms.service;


import com.srms.dto.DashboardResponse;
import com.srms.dto.UserSummary;
import com.srms.model.Status;
import com.srms.repository.UserRepository;
import com.srms.repository.projection.UserSummaryProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashBoardService {

    private final UserRepository userRepository;

    private static final List<Status> BOTTOM_STATUSES = List.of(
            Status.BREAK,
            Status.MEETING,
            Status.BRB,
            Status.STATION_ISSUES,
            Status.AWAY
    );

    public DashboardResponse buildDashboard(){
        List<UserSummaryProjection> raw = userRepository.findAllProjectedBy();

        List<UserSummary> summaries = raw.stream().map(p-> new UserSummary(p.getId(),p.getFullName(), p.getStatus().name())).toList();

        Map<String, List<UserSummary>> grouped = summaries.stream().collect(Collectors.groupingBy(UserSummary::getStatus));

        Map<String, List<UserSummary>> platforms = new LinkedHashMap<>();

        for(Status status : Status.values()){
            List<UserSummary> users = grouped.getOrDefault(status.name(), List.of());
            users = users.stream().sorted(Comparator.comparing(UserSummary::getFullName)).toList();
            platforms.put(status.name(),users);
        }

        Set<String> bottomNames = BOTTOM_STATUSES.stream().map(Status::name).collect(Collectors.toSet());

        List<UserSummary> bottomPanel = summaries.stream().filter(u -> bottomNames.contains(u.getStatus())).sorted(Comparator.comparing(UserSummary::getFullName)).toList();

        return new DashboardResponse(platforms, bottomPanel);


    }
}
