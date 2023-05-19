package com.project.vcs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private String lastName;

    private String middleName;

    private String firstName;

    private LocalDate dob;

    private String homeTown;

    private int phoneNumber;

    private String ingameName;
}
