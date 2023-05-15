package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
//@NamedQuery(name = "Airplane.findByModel", query =" select a from Airplane a where a.model = ?1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dob;
    @Column(name = "hometown", nullable = false)
    private String homeTown;
    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;
    @Column(name = "ingame_name", nullable = false)
    private String ingameName;
    @Column(name = "role", nullable = false)
    private String role;
}
