package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "location", nullable = false)
    private String location;
    @ManyToOne
    @JoinColumn(name = "caster_id", nullable = false)
    private Caster caster;
    @ManyToOne
    @JoinColumn(name = "tournament", nullable = false)
    private Tournament tournament;

}
