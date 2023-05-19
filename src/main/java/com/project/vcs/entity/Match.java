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
