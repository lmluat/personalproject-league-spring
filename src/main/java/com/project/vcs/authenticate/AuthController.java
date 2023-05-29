package com.project.vcs.authenticate;
import com.project.vcs.dto.UserDTO;
import com.project.vcs.jwt.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public interface AuthController {
    @PostMapping("/login")
    ResponseEntity<?> authenticateUser(@Valid @RequestBody JwtRequest loginRequest);
    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO );
}