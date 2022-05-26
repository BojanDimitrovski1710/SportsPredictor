package com.example.Web.league;

import com.example.Web.team.Team;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Access(AccessType.PROPERTY)
public class League {
    @SequenceGenerator(
            name = "league_sequence",
            sequenceName = "league_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "league_sequence"
    )
    @Id
    private long id;

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "name")
    public List<Team> getParticipating_teams() {
        return participating_teams;
    }

    private String name;
    @ElementCollection(targetClass = Team.class)
    private List<Team> participating_teams;

    public League(String name) {
        this.name = name;
    }

    public League(String name, List<Team> participating_teams) {
        this.name = name;
        this.participating_teams = participating_teams;
    }
}
