package com.project.vcs.service;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.repository.CasterRepository;
import com.project.vcs.service.mapper.CasterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CasterService {
    private final CasterRepository casterRepository;
    public List<CasterDTO> getAllCaster(){
        return CasterMapper.INSTANCE.toDTOs(casterRepository.findAll());
    }
    public Caster createCaster(CasterDTO casterDTO){
        Caster caster = Caster.builder()
                .lastName(casterDTO.getLastName())
                .middleName(casterDTO.getMiddleName())
                .firstName(casterDTO.getFirstName())
                .hometown(casterDTO.getHometown())
                .dob(casterDTO.getDob())
                .build();
        return casterRepository.save(caster);
    }
}
