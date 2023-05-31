package com.project.vcs.service;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.exception.DemoException;
import com.project.vcs.jwt.JwtUtils;
import com.project.vcs.repository.CasterRepository;
import com.project.vcs.service.mapper.CasterMapper;
import lombok.RequiredArgsConstructor;

import lombok.extern.java.Log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
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
    public CasterDTO updateCaster(CasterDTO casterDTO, Long casterId){
        Caster caster = casterRepository.findById(casterId).orElseThrow(DemoException::CasterNotFound);
        log.error(DemoException.CasterNotFound().getMessage());
        if (casterDTO.getLastName() != null) {
            caster.setLastName(casterDTO.getLastName());
        }
        if (casterDTO.getMiddleName() != null) {
            caster.setMiddleName(casterDTO.getMiddleName());
        }
        if (casterDTO.getFirstName() != null) {
            caster.setFirstName(casterDTO.getFirstName());
        }
        if (casterDTO.getDob() != null) {
            caster.setDob(casterDTO.getDob());
        }
        if (casterDTO.getHometown() != null) {
            caster.setHometown(casterDTO.getHometown());
        }

        casterRepository.save(caster);
        return CasterMapper.INSTANCE.toDTO(caster);
    }
    public void deleteCaster(Long casterId){
        Caster caster = casterRepository.findById(casterId).orElseThrow(DemoException::CasterNotFound);
        log.error(DemoException.CasterNotFound().getMessage());
        casterRepository.delete(caster);
    }
}
