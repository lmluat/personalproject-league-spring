package com.project.vcs.service;

import com.project.vcs.dto.UserDTO;
import com.project.vcs.entity.User;
import com.project.vcs.entity.UserRoleAssignment;
import com.project.vcs.jwt.JwtRequest;
import com.project.vcs.jwt.JwtResponse;
import com.project.vcs.jwt.JwtUtils;
import com.project.vcs.jwt.MessageResponse;
import com.project.vcs.repository.UserRepository;
import com.project.vcs.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<UserDTO> getUsers() {
        return UserMapper.INSTANCE.mapToDtos(userRepository.findAll());
    }

    public ResponseEntity<?> registerUser(UserDTO userDTO) {
        log.info("dto role: "+userDTO.getRoleList().size());

        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        User user = new User(userDTO.getUsername(), encoder.encode(userDTO.getPassword()));
        log.info("username : " + user.getUsername());
        log.info("user test: ");
        List<UserRoleAssignment> userRoleAssignmentList = new ArrayList<>();
        userDTO.getRoleList().forEach(u -> {
            UserRoleAssignment userRoleAssignment = new UserRoleAssignment();

            userRoleAssignment.setUsers(user);
            userRoleAssignment.setERole(u);

            log.info("roleasdasds : " + u.name() );

            userRoleAssignmentList.add(userRoleAssignment);
        });

        user.setRoles(userRoleAssignmentList);
        log.info("roles: "+user.getRoles().size());
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    public JwtResponse authenticateUser(JwtRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponse(jwt,
                userDetails.getUsername(),
                roles);
    }

}
