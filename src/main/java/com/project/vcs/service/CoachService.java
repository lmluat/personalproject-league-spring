package com.project.vcs.service;

import com.project.vcs.dto.CoachDTO;
import com.project.vcs.entity.Coach;
import com.project.vcs.exception.DemoException;
import com.project.vcs.repository.CoachRepository;
import com.project.vcs.service.mapper.CoachMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;
    public List<Coach> getAllCoach(){
        return coachRepository.findAll();
    }
    public CoachDTO createCoach(CoachDTO coachDTO){
        Coach coach = Coach.builder()
                .lastName(coachDTO.getLastName())
                .middleName(coachDTO.getMiddleName())
                .firstName(coachDTO.getFirstName())
                .dob(coachDTO.getDob())
                .hometown(coachDTO.getHometown())
                .ingameName(coachDTO.getIngameName())
                .build();
        coachRepository.save(coach);
        return CoachMapper.INSTANCE.toDTO(coach);
    }
    public CoachDTO updateCoach(CoachDTO coachDTO, Long id){
        log.error(DemoException.CoachNotFound().getMessage());
        Coach coach = coachRepository.findById(id).orElseThrow(DemoException::CoachNotFound);
        if(coachDTO.getFirstName() != null){
            coach.setFirstName(coachDTO.getFirstName());
        }
        if(coachDTO.getMiddleName() != null){
            coach.setMiddleName(coachDTO.getMiddleName());
        }
        if(coachDTO.getLastName() != null){
            coach.setLastName(coachDTO.getLastName());
        }
        if (coachDTO.getDob() != null) {
            coach.setDob(coachDTO.getDob());
        }
        if (coachDTO.getHometown() != null) {
            coach.setHometown(coachDTO.getHometown());
        }
        if (coachDTO.getIngameName() != null) {
            coach.setIngameName(coachDTO.getIngameName());
        }

        coachRepository.save(coach);
        return CoachMapper.INSTANCE.toDTO(coach);

    }
    public void deleteCoach(Long coachId){
        log.error(DemoException.CoachNotFound().getMessage());
        Coach coach = coachRepository.findById(coachId).orElseThrow(DemoException::CoachNotFound);
        coachRepository.delete(coach);
    }

}
