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
        Coach coach = new Coach(coachDTO);
        return coachRepository.save(coach);
    }
}
