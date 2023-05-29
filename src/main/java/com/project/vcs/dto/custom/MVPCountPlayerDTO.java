package com.project.vcs.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MVPCountPlayerDTO {
    private String playerName;
    private int numberOfMVP;
}
