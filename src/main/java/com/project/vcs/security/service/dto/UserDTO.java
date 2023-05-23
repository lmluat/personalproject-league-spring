package com.project.vcs.security.service.dto;

import com.project.vcs.security.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String password;
    private List<Role> roleList;
}
