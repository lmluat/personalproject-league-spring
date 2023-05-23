package com.project.vcs.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private List<UserRoleAssignment> roles = new ArrayList<>();
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
