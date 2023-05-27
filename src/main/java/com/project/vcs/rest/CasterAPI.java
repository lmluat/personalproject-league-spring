package com.project.vcs.rest;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.entity.Caster;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
public interface CasterAPI {
    @GetMapping("/casters")
    ResponseEntity<List<CasterDTO>> getAllCaster();
    @PostMapping("/casters/id")
    ResponseEntity<Caster> createCaster(@RequestBody CasterDTO casterDTO);
    @PutMapping("/casters/{id}")
    ResponseEntity<CasterDTO> updateCaster(@PathVariable("id") Long id,
                                           @RequestBody CasterDTO casterDTO);
    @DeleteMapping("/casters/{id}")
    ResponseEntity<Void> deleteCaster(@PathVariable("id") Long id);
}
