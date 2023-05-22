package com.project.vcs.entity;

import com.project.vcs.dto.CoachDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coach", uniqueConstraints = {@UniqueConstraint(columnNames = {"ingame_name"})})
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "date_of_birth")
    private LocalDate dob;
    @Column(name = "hometown")
    private String hometown;
    @Column(name = "ingame_name")
    private String ingameName;
    public Coach(CoachDTO coachDTO){
        this.lastName = coachDTO.getLastName();
        this.middleName = coachDTO.getMiddleName();
        this.firstName = coachDTO.getFirstName();
        this.dob = coachDTO.getDob();
        this.hometown = coachDTO.getHometown();
        this.ingameName = coachDTO.getIngameName();
    }
}
