package com.project.vcs.service.mapper;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.entity.Caster;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CasterMapper {
    CasterMapper INSTANCE = Mappers.getMapper(CasterMapper.class);
    CasterDTO toDTO(Caster caster);
    List<CasterDTO> toDTOs(List<Caster> casters);
}
