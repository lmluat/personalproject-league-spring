package com.project.vcs.authenticate;

import com.project.vcs.dto.UserDTO;
import com.project.vcs.jwt.JwtRequest;
import com.project.vcs.jwt.JwtResponse;
import com.project.vcs.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController{
    private final UserServiceImpl userServiceImpl;

    public ResponseEntity<JwtResponse> authenticateUser(JwtRequest loginRequest) {
        return ResponseEntity.ok(userServiceImpl.authenticateUser(loginRequest));
    }
    public ResponseEntity<?> registerUser(UserDTO userDTO) {
        return ResponseEntity.ok(userServiceImpl.registerUser(userDTO));
    }
}
