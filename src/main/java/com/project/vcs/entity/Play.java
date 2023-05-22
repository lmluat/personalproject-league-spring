package com.project.vcs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "play")
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="player_id", nullable = false)
    private Player player;
    @ManyToOne
    @JoinColumn(name ="team_detail_id", nullable = false)
    private TeamDetail teamDetail;
    @Column(name="position", nullable = false)
    private String position;
    @Column(name="is_captain")
    private Boolean isCaptain;

}
