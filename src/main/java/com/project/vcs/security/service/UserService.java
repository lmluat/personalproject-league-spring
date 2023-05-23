package com.project.vcs.security.service;

import com.project.vcs.security.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
