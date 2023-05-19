package com.project.vcs.service;

import com.project.vcs.entity.Caster;
import com.project.vcs.repository.CasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CasterService {
    private final CasterRepository casterRepository;
    public List<Caster> getAllCaster(){
        return casterRepository.findAll();
    }
}
