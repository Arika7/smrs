package com.srms.service;


import com.srms.dto.StatusChangeRequest;
import com.srms.dto.StatusChangeResponse;
import com.srms.model.Status;
import com.srms.model.User;
import com.srms.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository userRepository;
    private final Clock clock;

    @Transactional
    public StatusChangeResponse changeStatus(StatusChangeRequest request){
        Long userId = request.getUserId() != null ? request.getUserId() : 1L;
        User target = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Status newStatus;

        try {
            newStatus = Status.valueOf(request.getStatus().name());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid status:" + request.getStatus().name());
        }
        LocalDateTime now = LocalDateTime.now(clock);
        if (newStatus == Status.BRB) {
            if(request.getBrbMins() == null || request.getBrbMins() <= 0) {throw new IllegalArgumentException("BRB status requires a valid number of minutes.");}

            target.setBreakStartTime(now);
            target.setBreakEndTime(now.plusMinutes(request.getBrbMins()));
    } else if (newStatus == Status.BREAK) {
            target.setBreakStartTime(now);
            target.setBreakEndTime(now.plusHours(1));
        }
        else    {
        target.setBreakStartTime(null);
        target.setBreakEndTime(null);
        }

        target.setStatus(newStatus);
        target.setLastStatusUpdate(now);
        target.setStatusComment(request.getComment());

        return new StatusChangeResponse(target.getId(), target.getFullName(), newStatus.name(), now);
    }

    }
