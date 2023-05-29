package com.project.vcs.service;

import com.project.vcs.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
