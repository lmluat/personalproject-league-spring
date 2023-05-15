package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@NamedQuery(name = "Airplane.findByModel", query =" select a from Airplane a where a.model = ?1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team")
public class TeamHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tournament", nullable = false)
    private Tournament tournament;
    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;
    @Column(name = "captain", nullable = false)
    private Player captain;
    @ManyToOne
    @JoinColumn(name = "coach", nullable = false)
    private Coach coach;
    @Column(name = "sponsor", nullable = false)
    private String sponsor;
}
