package com.project.vcs.service.mapper;

import com.project.vcs.dto.CasterDTO;
import com.project.vcs.dto.MatchDetailDTO;
import com.project.vcs.entity.Caster;
import com.project.vcs.entity.MatchDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchDetailMapper {
    MatchDetailMapper INSTANCE = Mappers.getMapper(MatchDetailMapper.class);
    MatchDetailDTO toDTO(MatchDetail matchDetail);
    List<MatchDetailDTO> toDTOs(List<MatchDetailDTO> matchDetailDTOS);
}
