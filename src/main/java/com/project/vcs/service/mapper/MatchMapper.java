package com.project.vcs.service.mapper;

import com.project.vcs.dto.MatchDTO;
import com.project.vcs.entity.Match;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.lang.invoke.CallSite;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);
    MatchDTO toDTO(Match match);
    List<MatchDTO> toDTOs(List<Match> matchList);
}
