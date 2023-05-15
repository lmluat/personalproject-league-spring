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
public class WeeklyRankingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "team_history_id", nullable = false)
    private TeamHistory teamHistory;
    @Column(name = "rank", nullable = false)
    private int rank;
    @Column(name = "point", nullable = false)
    private int point;
    @Column(name = "sponsor", nullable = false)
    private int week;
    @ManyToOne
    @JoinColumn(name = "tournament", nullable = false)
    private Tournament tournament;

}
