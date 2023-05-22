package com.project.vcs.rest;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.service.CasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CasterResoure implements CasterAPI{
    private final CasterService casterService;

    @Override
    public ResponseEntity<List<CasterDTO>> getAllCaster() {
        return ResponseEntity.ok(casterService.getAllCaster());
    }

    @Override
    public ResponseEntity<Caster> createCaster(CasterDTO casterDTO) {
        return ResponseEntity.ok(casterService.createCaster(casterDTO));
    }
}
