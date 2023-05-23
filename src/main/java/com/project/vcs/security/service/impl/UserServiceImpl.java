package com.project.vcs.security.service.impl;

import com.project.vcs.security.entity.User;
import com.project.vcs.security.entity.UserRoleAssignment;
import com.project.vcs.security.jwt.JwtRequest;
import com.project.vcs.security.jwt.JwtResponse;
import com.project.vcs.security.jwt.JwtUtils;
import com.project.vcs.security.repository.UserRepository;
import com.project.vcs.security.service.UserService;
import com.project.vcs.security.service.dto.UserDTO;
import com.project.vcs.security.service.dto.custom.UserCustomDTO;
import com.project.vcs.security.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
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
    public UserCustomDTO registerUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), encoder.encode(userDTO.getPassword()));

        List<UserRoleAssignment> userRoleAssignmentList = new ArrayList<>();
        user.setRoleList(userDTO.getRoleList());

        userDTO.getRoleList().forEach(u -> {
            UserRoleAssignment userRoleAssignment = new UserRoleAssignment();

            userRoleAssignment.setUsers(user);
            userRoleAssignment.setRole(u);

            userRoleAssignmentList.add(userRoleAssignment);
        });

        user.setRoles(userRoleAssignmentList);
        userRepository.save(user);

        return UserMapper.INSTANCE.mapToCustomDTO(user);

//        return new UserCustomDTO().builder()
//                .username(userDTO.getUsername())
//                .roleList(userDTO.getRoleList())
//                .build();
    }
    public ResponseEntity<?> authenticateUser(JwtRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles));
    }
}
