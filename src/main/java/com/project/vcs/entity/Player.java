package com.project.vcs.entity;

import com.project.vcs.dto.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player", uniqueConstraints = {@UniqueConstraint(columnNames = {"ingame_name"})})
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
    @Column(name = "date_of_birth")
    private LocalDate dob;
    @Column(name = "hometown", nullable = false)
    private String homeTown;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "ingame_name", nullable = false)
    private String ingameName;
    public Player(PlayerDTO playerDTO){
        this.dob = playerDTO.getDob();
        this.firstName = playerDTO.getFirstName();
        this.middleName = playerDTO.getMiddleName();
        this.lastName = playerDTO.getLastName();
        this.homeTown = playerDTO.getHometown();
        this.phoneNumber = playerDTO.getPhoneNumber();
        this.ingameName = playerDTO.getIngameName();
    }
}
