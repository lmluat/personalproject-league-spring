package com.project.vcs.authenticate.impl;

import com.project.vcs.authenticate.AuthController;
import com.project.vcs.security.jwt.JwtRequest;
import com.project.vcs.security.jwt.JwtResponse;
import com.project.vcs.security.jwt.JwtUtils;
import com.project.vcs.security.service.dto.UserDTO;
import com.project.vcs.security.service.impl.UserDetailsImpl;
import com.project.vcs.security.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final UserServiceImpl userServiceImpl;

    @Override
    public ResponseEntity<?> authenticateUser(JwtRequest loginRequest) {
        return ResponseEntity.ok(userServiceImpl.authenticateUser(loginRequest));
    }

    @Override
    public ResponseEntity<?> registerUser(UserDTO userDTO) {
        return ResponseEntity.ok(userServiceImpl.registerUser(userDTO));
    }
}
