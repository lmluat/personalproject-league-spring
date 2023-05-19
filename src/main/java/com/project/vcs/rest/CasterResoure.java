package com.project.vcs.rest;

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
    public ResponseEntity<List<Caster>> getAllCaster() {
        return ResponseEntity.ok(casterService.getAllCaster());
    }
}
