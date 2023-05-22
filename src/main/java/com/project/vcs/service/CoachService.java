package com.project.vcs.service;

import com.project.vcs.dto.CoachDTO;
import com.project.vcs.entity.Coach;
import com.project.vcs.repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;
    public List<Coach> getAllCoach(){
        return coachRepository.findAll();
    }
    public Coach createCoach(CoachDTO coachDTO){
        Coach coach = Coach.builder()
                .lastName(coachDTO.getLastName())
                .middleName(coachDTO.getMiddleName())
                .firstName(coachDTO.getFirstName())
                .dob(coachDTO.getDob())
                .hometown(coachDTO.getHometown())
                .ingameName(coachDTO.getIngameName())
                .build();
        return coachRepository.save(coach);
    }
}
